package com.example.backend.service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor


public class FraudDetectionService {
    private final String flaskApiUrl = "http://127.0.0.1:5000/predict"; // Flask API URL

    public String getFraudPrediction(Map<String, Object> inputData) {
        RestTemplate restTemplate = new RestTemplate();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request entity with headers and data
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(inputData, headers);

        // Send POST request to Flask API
        ResponseEntity<String> response = restTemplate.exchange(flaskApiUrl, HttpMethod.POST, requestEntity, String.class);

        // Get the prediction result
        return response.getBody();
    }
}
