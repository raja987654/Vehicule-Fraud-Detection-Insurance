package com.example.backend.controller;
import com.example.backend.entity.Sinistre;
import com.example.backend.repository.SinistreRepository;
import com.example.backend.service.FraudDetectionService;
import com.example.backend.service.SinistreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")

public class FraudDetectionController {
    @Autowired
    private FraudDetectionService fraudDetectionService;
    @Autowired
    private SinistreService ss;

    @PostMapping("/fraud")
    public String detectFraud(@RequestBody Map<String, Object> inputData) {
        return fraudDetectionService.getFraudPrediction(inputData);
    }

}

