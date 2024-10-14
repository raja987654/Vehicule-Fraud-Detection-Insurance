package com.example.backend.controller;

import com.example.backend.entity.Expert;
import com.example.backend.service.IexpertService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@AllArgsConstructor
@RequestMapping("/Expert")
public class ExpertController {
    private IexpertService service;

    @PostMapping("/add")
    public Expert saveExpert(@RequestBody Expert e) {
        return service.saveExpert(e);
    }

    @GetMapping("/all")
    public List<Expert> getExperts() {
        return service.getExperts();
    }

    @GetMapping("/{id}")
    public Expert getExpertById(@PathVariable int id) {
        return service.getExpertById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpert(@PathVariable int id) {
        service.deleteExpert(id);
    }
}
