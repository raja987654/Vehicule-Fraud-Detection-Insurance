package com.example.backend.repository;

import com.example.backend.entity.Evaluation;
import com.example.backend.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface expertRepository extends JpaRepository<Expert,Integer> {
}
