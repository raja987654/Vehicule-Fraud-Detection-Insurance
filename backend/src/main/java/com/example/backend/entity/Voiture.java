package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marque;
    private String modele;
    private String matricule;
    private int annee;
    private float valeur;
    private String VehicleCategory;
    @JsonIgnore
    @ManyToOne
    private utilisateur utilisateur;

    @JsonIgnore
    @OneToMany(mappedBy = "voiture1" ,cascade = CascadeType.ALL)
    private List<Sinistre> sinistres;


}
