package com.example.backend.controller;

import com.example.backend.entity.Voiture;
import com.example.backend.service.IvoitureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@AllArgsConstructor
@RequestMapping("/Voiture")
public class VoitureController {
    private IvoitureService service;

    @PostMapping("/add/{idu}")
    public Voiture saveCar(@RequestBody Voiture v, @PathVariable int idu) {
        return service.saveCar(v, idu);
    }

    @GetMapping("/all")
    public List<Voiture> getCars() {
        return service.getCars();
    }

    @GetMapping("/{id}")
    public Voiture getCarById(@PathVariable int id) {
        return service.getCarById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable int id) {
        service.deleteCar(id);
    }

    @PutMapping("/update/{id}")
    public Voiture updateUser(@PathVariable int id,@RequestBody Voiture v) {
        return service.updateUser(id, v);
    }
}
