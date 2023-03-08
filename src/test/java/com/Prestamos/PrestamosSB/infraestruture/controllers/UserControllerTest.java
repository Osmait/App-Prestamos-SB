package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    private  final TestRestTemplate restTemplate = new TestRestTemplate();


    @Test
   public void getUser() {
        ResponseEntity<User[]> response = restTemplate.getForEntity("http://localhost:"+ port + "/user",User[].class);



        System.out.println(Arrays.toString(response.getBody()));
        assertEquals(HttpStatus.OK,response.getStatusCode());



    }

    @Test
    void testCreateUser() {

    }
}