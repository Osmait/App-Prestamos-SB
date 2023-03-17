package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.UserCreator;
import com.Prestamos.PrestamosSB.domain.User;
import jakarta.transaction.Transactional;
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
@Transactional
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

   @Autowired
   UserCreator userCreator;

    @BeforeEach
    void setUp(){
        User user = User.builder().email("saulburgos6@gmail.com").name("saul").lastName("burgos").password("12345678").build();
        userCreator.create(user);
    }


    @Test
    void autenticate() throws Exception {

        String body ="{\"email\": \"saulburgos6@gmail.com\", \"password\": \"12345678\"}";
        mockMvc.perform(post("/login").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    void autenticateFail() throws Exception {

        String body ="{\"email\": \"saulburgos@gmail.com\", \"password\": \"123456\"}";
        mockMvc.perform(post("/login").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());


    }
}