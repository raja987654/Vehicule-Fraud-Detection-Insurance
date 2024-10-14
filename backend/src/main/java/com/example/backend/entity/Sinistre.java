package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Sinistre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateSinistre;
    private LocalDate dateDeclaration;
    private String description;
    private String AccidentArea;
    private int NumberOfCars;
    @Enumerated(EnumType.STRING)
    private EtatSinistre etat;
    @Enumerated(EnumType.STRING)
    private Fault fault;

    @JsonIgnore
    @ManyToOne
    private Voiture voiture1;


    @JsonIgnore
    @OneToOne(mappedBy = "sinistreEvaluation" ,cascade = CascadeType.ALL)
    private Evaluation evaluation
            ;
}
