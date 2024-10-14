package com.example.backend.service;

import com.example.backend.entity.Evaluation;

import javax.mail.MessagingException;
import java.util.List;

public interface IEvaluationService {
    Evaluation saveEvaluation(Evaluation e, int ids);

    Evaluation affecterExpert(int id, int ide);

    Evaluation accepterSinistre(int id, Evaluation e);

    Evaluation refuserSinistre(int id,Evaluation e);

    List<Evaluation> getEvaluations();

    Evaluation getEvaluationById(int id);

    void deleteEvaluation(int id);

    void sendEmail(String tomail, String Subject, String body) throws MessagingException;
}
