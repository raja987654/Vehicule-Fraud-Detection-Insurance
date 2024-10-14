package com.example.backend.repository;

import com.example.backend.entity.Expert;
import com.example.backend.entity.Sinistre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinistreRepository extends JpaRepository<Sinistre,Integer> {
}
