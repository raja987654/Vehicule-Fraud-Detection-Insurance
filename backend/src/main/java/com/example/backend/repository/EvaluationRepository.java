package com.example.backend.repository;

import com.example.backend.entity.Evaluation;
import com.example.backend.entity.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {
}
