package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateEvaluation;
    private String rapport;
    @Enumerated(EnumType.STRING)
    private EtatEval etat;

    @JsonIgnore
    @OneToOne
    private Sinistre sinistreEvaluation;

    @JsonIgnore
    @ManyToOne
    private Expert expert;
}
