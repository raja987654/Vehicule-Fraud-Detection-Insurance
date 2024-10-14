package com.example.backend.controller;

import com.example.backend.entity.Contrat;
import com.example.backend.service.IcontratService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@AllArgsConstructor
@RequestMapping("/Contrat")
public class ContratController {

    private IcontratService service;

    @PostMapping("/add/{idu}")

    public Contrat saveContrat(@RequestBody Contrat c,@PathVariable int idu) {
        return service.saveContrat(c, idu);
    }

    @GetMapping("/all")

    public List<Contrat> getContrats() {
        return service.getContrats();
    }

    @GetMapping("/{id}")

    public Contrat getContratById(@PathVariable int id) {
        return service.getContratById(id);
    }

    @DeleteMapping("/delete/{id}")

    public void deleteContrat(@PathVariable int id) {
        service.deleteContrat(id);
    }
}
