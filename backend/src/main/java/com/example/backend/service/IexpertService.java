package com.example.backend.service;

import com.example.backend.entity.Expert;

import java.util.List;

public interface IexpertService {
    Expert saveExpert(Expert e);

    List<Expert> getExperts();

    Expert getExpertById(int id);

    void deleteExpert(int id);
}
