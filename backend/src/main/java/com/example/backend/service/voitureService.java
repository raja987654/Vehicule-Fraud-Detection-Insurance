package com.example.backend.service;

import com.example.backend.entity.Voiture;
import com.example.backend.entity.utilisateur;
import com.example.backend.repository.voitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class voitureService implements IvoitureService {

    private voitureRepository repository;
    private utilisateurService se;

    @Override
    public Voiture saveCar(Voiture v, int idu )  {
        utilisateur u;
        u=se.getUserById(idu);
        v.setUtilisateur(u);
        return   repository.save(v);
    }

    @Override
    public List<Voiture> getCars(){
        return repository.findAll();
    }

    @Override
    public Voiture getCarById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteCar(int id){
        repository.deleteById(id);
    }

    @Override
    public Voiture updateUser(int id, Voiture v){
        Voiture existingCar=repository.findById(id).orElse(null);
        existingCar.setMarque(v.getMarque());
        existingCar.setAnnee(v.getAnnee());
        existingCar.setModele(v.getModele());
        existingCar.setMatricule(v.getMatricule());
        existingCar.setValeur(v.getValeur());

        return repository.save(existingCar);

    }
}
