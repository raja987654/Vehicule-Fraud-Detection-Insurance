package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private PolicyType policyType;
    @Enumerated(EnumType.STRING)
    private EtatContrat etat;

    @JsonIgnore
    @OneToOne
    private utilisateur utilisateurContrat;
}
