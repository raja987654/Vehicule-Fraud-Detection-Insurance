package com.example.backend.controller;

import com.example.backend.entity.Evaluation;
import com.example.backend.service.IEvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@CrossOrigin("*")

@AllArgsConstructor
@RequestMapping("/Evaluation")
public class EvaluationController {
    private IEvaluationService service;

    @PostMapping("/add/{ids}")
    public Evaluation saveEvaluation(@RequestBody Evaluation e,@PathVariable int ids) {
        return service.saveEvaluation(e, ids);
    }

    @PostMapping("/affecter/{id}/{ide}")
    public Evaluation affecterExpert(@PathVariable int id,@PathVariable int ide) {
        return service.affecterExpert(id, ide);
    }

    @PostMapping("/accepter/{id}")

    public Evaluation accepterSinistre(@PathVariable int id,@RequestBody Evaluation e) {
        return service.accepterSinistre(id,e);
    }

    @PostMapping("/refuser")
    public Evaluation refuserSinistre(@PathVariable int id,@RequestBody Evaluation e) {
        return service.refuserSinistre(id,e);
    }

    @GetMapping("/all")
    public List<Evaluation> getEvaluations() {
        return service.getEvaluations();
    }

    @GetMapping("/{id}")
    public Evaluation getEvaluationById(int id) {
        return service.getEvaluationById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvaluation(@PathVariable int id) {
        service.deleteEvaluation(id);
    }


}
