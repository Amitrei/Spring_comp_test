package com.amitrei.WireMockTest.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
    @Value("${API_URL}")
    private String API_URL;
    private RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/users")
    private ResponseEntity<String> getUsers() {
        String results = restTemplate.getForEntity(API_URL +"/users",String.class).getBody();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/users/1")
    private ResponseEntity<String> getUser() {
        String results = restTemplate.getForEntity(API_URL +"/users/1",String.class).getBody();
        return ResponseEntity.ok(results);
    }
}
