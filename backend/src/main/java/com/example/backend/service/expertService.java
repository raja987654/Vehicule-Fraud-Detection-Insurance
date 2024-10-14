package com.example.backend.service;

import com.example.backend.entity.Expert;
import com.example.backend.repository.expertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class expertService implements IexpertService {
    private expertRepository repository;

    @Override
    public Expert saveExpert(Expert e)  {
        return   repository.save(e);
    }

    @Override
    public List<Expert> getExperts(){
        return repository.findAll();
    }

    @Override
    public Expert getExpertById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteExpert(int id){
        repository.deleteById(id);
    }

}
