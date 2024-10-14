package com.example.backend.service;

import com.example.backend.entity.Sinistre;

import java.util.List;

public interface IsinistreService {
    Sinistre saveSinistre(Sinistre s, int idv);

    List<Sinistre> getSinistres();

    Sinistre getSinistreById(int id);

    void deleteSinistre(int id);
}
