package com.example.backend.repository;

import com.example.backend.entity.Contrat;
import com.example.backend.entity.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
}
