package com.example.backend.service;

import com.example.backend.entity.Contrat;

import java.util.List;

public interface IcontratService {
    Contrat saveContrat(Contrat c, int idu);

    List<Contrat> getContrats();

    Contrat getContratById(int id);

    void deleteContrat(int id);
}
