package com.example.backend.service;

import com.example.backend.entity.Contrat;
import com.example.backend.entity.utilisateur;
import com.example.backend.repository.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ContratService implements IcontratService {
    private ContratRepository repository;
    private utilisateurService se;

    @Override
    public Contrat saveContrat(Contrat c, int idu)  {
        utilisateur u;
        u=se.getUserById(idu);
        c.setUtilisateurContrat(u);
        return   repository.save(c);
    }

    @Override
    public List<Contrat> getContrats(){
        return repository.findAll();
    }

    @Override
    public Contrat getContratById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteContrat(int id){
        repository.deleteById(id);
    }


}
