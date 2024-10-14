package com.example.backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String sex;
    private String Prenom;
    private Date dateNaissance;
    private int numP;
    private Date dateP;
    private String profession;
    private String addresse;
    private String email;
    private int num;
    private int mdp;
    private int nbrSinistre;
    private int role=1;
    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur" ,cascade = CascadeType.ALL)
    private List<Voiture> voitures;

    @JsonIgnore
    @OneToOne(mappedBy = "utilisateurContrat" ,cascade = CascadeType.ALL)
    private Contrat contrat;
}
