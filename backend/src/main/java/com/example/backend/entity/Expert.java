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
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String Specialite;
    private Date dateCertif;
    private int role=0;


    @JsonIgnore
    @OneToMany(mappedBy = "expert" ,cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;
}
