package com.example.backend.repository;

import com.example.backend.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface voitureRepository extends JpaRepository<Voiture,Integer> {
}
