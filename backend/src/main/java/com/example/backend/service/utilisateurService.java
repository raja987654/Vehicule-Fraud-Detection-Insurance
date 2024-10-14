package com.example.backend.service;

import com.example.backend.entity.utilisateur;
import com.example.backend.repository.utilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class utilisateurService implements IutilisateurService {
    private utilisateurRepository repository;

    @Override
    public utilisateur saveUtilisateur(utilisateur u)  {
        return   repository.save(u);
    }

    @Override
    public List<utilisateur> getUsers(){
        return repository.findAll();
    }

    @Override
    public utilisateur getUserById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(int id){
        repository.deleteById(id);
    }

    @Override
    public utilisateur updateUser(int id,utilisateur u){
        utilisateur existingUser=repository.findById(id).orElse(null);
        existingUser.setNom(u.getNom());
        existingUser.setPrenom(u.getPrenom());
        existingUser.setAddresse(u.getAddresse());
        existingUser.setEmail(u.getEmail());
        existingUser.setMdp(u.getMdp());
        existingUser.setNum(u.getNum());
        return repository.save(existingUser);

    }
}
