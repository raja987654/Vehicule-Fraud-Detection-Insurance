package com.example.backend.controller;

import com.example.backend.entity.Sinistre;
import com.example.backend.service.IsinistreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@AllArgsConstructor
@RequestMapping("/Sinistre")
public class SinistreController {
    private IsinistreService service;

    @PostMapping("/add/{idv}")
    public Sinistre saveSinistre(@RequestBody Sinistre s, @PathVariable int idv) {
        return service.saveSinistre(s, idv);
    }

    @GetMapping("/all")
    public List<Sinistre> getSinistres() {
        return service.getSinistres();
    }

    @GetMapping("/{id}")
    public Sinistre getSinistreById(@PathVariable int id) {
        return service.getSinistreById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSinistre(@PathVariable int id) {
        service.deleteSinistre(id);
    }
}
