package com.example.backend.service;

import com.example.backend.entity.*;
import com.example.backend.repository.SinistreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SinistreService implements IsinistreService{
    private SinistreRepository repository;
    private IvoitureService vs;
    private IEvaluationService es;

    @Override
    public Sinistre saveSinistre(Sinistre s, int idv)  {
        Voiture v;
        v=vs.getCarById(idv);
        s.setVoiture1(v);
        s.setEtat(EtatSinistre.en_cours);

        Evaluation e = new Evaluation();

        repository.save(s);
        es.saveEvaluation(e,s.getId());

        return   repository.save(s);
    }

    @Override
    public List<Sinistre> getSinistres(){
        return repository.findAll();
    }

    @Override
    public Sinistre getSinistreById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteSinistre(int id){
        repository.deleteById(id);
    }


}
