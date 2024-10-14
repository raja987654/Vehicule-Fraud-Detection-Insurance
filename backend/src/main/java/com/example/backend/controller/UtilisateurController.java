package com.example.backend.controller;

import com.example.backend.entity.utilisateur;
import com.example.backend.service.IutilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@AllArgsConstructor
@RequestMapping("/user")
public class UtilisateurController {
    private IutilisateurService service;

    @PostMapping("/add")
    public utilisateur saveUtilisateur(@RequestBody utilisateur u) {
        return service.saveUtilisateur(u);
    }

    @GetMapping("/all")
    public List<utilisateur> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public utilisateur getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public utilisateur updateUser(@PathVariable int id, @RequestBody utilisateur u) {
        return service.updateUser(id, u);
    }
}
