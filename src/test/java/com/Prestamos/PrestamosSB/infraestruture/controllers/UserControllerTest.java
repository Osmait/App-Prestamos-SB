package com.Prestamos.PrestamosSB.infraestruture.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    private  final TestRestTemplate restTemplate = new TestRestTemplate();


    @Test
   public void getUser() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:"+ port + "/user",String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals("users",response.getBody());


    }

    @Test
    void createUser() {
    }
}