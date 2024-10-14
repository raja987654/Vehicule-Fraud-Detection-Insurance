from flask import Flask, request, jsonify
import pandas as pd
import numpy as np
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.model_selection import train_test_split
from imblearn.over_sampling import SMOTE
from sklearn.metrics import accuracy_score, precision_score, roc_auc_score, classification_report
from sklearn.linear_model import LogisticRegression
from sklearn.ensemble import RandomForestClassifier, GradientBoostingClassifier, ExtraTreesClassifier, AdaBoostClassifier, VotingClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.svm import SVC
from xgboost import XGBClassifier
import lightgbm as lgb
import joblib

app = Flask(__name__)

# Charger les données et préparer les modèles
df = pd.read_csv(r'fraud_oracle.csv', sep=';')

# Preprocessing et encodage
df.rename(columns={'FraudFound_P': 'Fraud'}, inplace=True)
encoder = LabelEncoder()
df['AgentType'] = encoder.fit_transform(df['AgentType'])
df['PoliceReportFiled'] = encoder.fit_transform(df['PoliceReportFiled'])

# Séparation des données en ensembles d'entraînement et de test
X = df.drop(['Fraud'], axis=1)
y = df['Fraud']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=42)

# Encodage des variables catégorielles
cat_cols = ['Month', 'DayOfWeek', 'DayOfWeekClaimed', 'MonthClaimed', 'AccidentArea', 'Sex', 'Fault', 'PolicyType', 'VehicleCategory']
trf = ColumnTransformer([
    ('ohe', OneHotEncoder(handle_unknown='ignore', sparse_output=False), cat_cols)
])

X_train_trf = trf.fit_transform(X_train)
X_test_trf = trf.transform(X_test)

# Application de SMOTE pour équilibrer les classes
smote = SMOTE()
X_train_smote, y_train_smote = smote.fit_resample(X_train_trf, y_train)

# Entraînement des modèles
algos = {
    'LogisticRegression': LogisticRegression(max_iter=1000),
    'RandomForestClassifier': RandomForestClassifier(),
    'GradientBoostingClassifier': GradientBoostingClassifier(),
    'ExtraTreesClassifier': ExtraTreesClassifier(),
    'KNeighborsClassifier': KNeighborsClassifier(),
    'SVC': SVC(),
    'XGBClassifier': XGBClassifier(),
    'Adaboost': AdaBoostClassifier()
}

models = {}
for name, algo in algos.items():
    model = algo
    model.fit(X_train_smote, y_train_smote)
    models[name] = model

# Ajouter le modèle LightGBM
lgb_clf = lgb.LGBMClassifier()
lgb_clf.fit(X_train_smote, y_train_smote)
models['LGBMClassifier'] = lgb_clf

# Ajouter le modèle XGBoost
xgb_clf = XGBClassifier()
xgb_clf.fit(X_train_smote, y_train_smote)
models['XGBClassifier'] = xgb_clf

# Voting Classifier
voting_clf = VotingClassifier([
    ('lgb', lgb_clf),
    ('xgb', xgb_clf),
])

voting_clf.fit(X_train_smote, y_train_smote)
models['VotingClassifier'] = voting_clf

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json(force=True)
    df_new = pd.DataFrame([data])

    # Encodage et transformation des nouvelles données
    df_new_trf = trf.transform(df_new)

    # Prédiction avec le VotingClassifier
    prediction = models['VotingClassifier'].predict(df_new_trf)
    result = 'Fraud' if prediction[0] == 1 else 'Not Fraud'

    return jsonify({'prediction': result})

if __name__ == '__main__':
    app.run(debug=True)
