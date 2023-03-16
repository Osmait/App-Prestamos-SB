package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.UserCreator;
import com.Prestamos.PrestamosSB.domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

   @Autowired
   UserCreator userCreator;

    @BeforeEach
    void setUp(){
        User user = new User("saul", "burgos", "saulburgos6@gmail.com", "12345678");
        userCreator.create(user);
    }


    @Test
    void autenticate() throws Exception {

        String body ="{\"email\": \"saulburgos6@gmail.com\", \"password\": \"12345678\"}";
        mockMvc.perform(post("/login").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
}