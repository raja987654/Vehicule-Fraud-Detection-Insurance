package com.example.backend.service;

import com.example.backend.entity.utilisateur;

import java.util.List;

public interface IutilisateurService {
    utilisateur saveUtilisateur(utilisateur u);

    List<utilisateur> getUsers();

    utilisateur getUserById(int id);

    void deleteUser(int id);

    utilisateur updateUser(int id, utilisateur u);
}
