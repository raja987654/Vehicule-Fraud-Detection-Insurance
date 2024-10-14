package com.example.backend.service;

import com.example.backend.entity.Voiture;
import lombok.AllArgsConstructor;

import java.util.List;

public interface IvoitureService {
    Voiture saveCar(Voiture v, int idu);

    List<Voiture> getCars();

    Voiture getCarById(int id);

    void deleteCar(int id);

    Voiture updateUser(int id, Voiture v);
}
