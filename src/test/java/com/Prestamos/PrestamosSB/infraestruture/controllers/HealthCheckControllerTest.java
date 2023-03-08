package com.Prestamos.PrestamosSB.infraestruture.controllers;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthCheckControllerTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void healthCheckTest() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/health-check", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Server Up", response.getBody());
    }


}