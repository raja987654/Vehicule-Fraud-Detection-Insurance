package com.example.backend.repository;

import com.example.backend.entity.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface utilisateurRepository extends JpaRepository<utilisateur,Integer> {
}
