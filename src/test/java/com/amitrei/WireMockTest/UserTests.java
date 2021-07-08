package com.amitrei.WireMockTest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;



@SpringBootTest
public class UserTests {
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${API_URL}")
    private String API_URL;

    @Test
     void getUsers() {
        // GET "https://jsonplaceholder.typicode.com/users"
       HttpStatus status = restTemplate.getForEntity(API_URL +"/users",String.class).getStatusCode();
       boolean hasBody = restTemplate.getForEntity(API_URL +"/users",String.class).hasBody();
       assertTrue(hasBody);
       assertEquals(200,status.value());
    }

    @Test
    void getSpecificUser() {
    // GET "https://jsonplaceholder.typicode.com/users/1"
        HttpStatus status = restTemplate.getForEntity(API_URL +"/users/1",String.class).getStatusCode();
        String body = restTemplate.getForEntity(API_URL +"/users/1",String.class).getBody();
        assertTrue(body.contains("\"id\": 1"));
        assertEquals(200,status.value());

    }
}
