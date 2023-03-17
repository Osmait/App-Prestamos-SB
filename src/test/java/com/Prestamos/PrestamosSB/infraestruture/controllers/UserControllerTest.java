package com.Prestamos.PrestamosSB.infraestruture.controllers;


import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    String[] fieldData = {
            "{\"name\": \"saul\", \"lastName\": \"burgos\",\"email\": \"saul@gmail.com\"}",
            "{\"name\": \"saul\", \"lastName\": \"burgos\", \"password\": \"12345678\"}",
            "{\"lastName\": \"burgos\",\"email\": \"saul@gmail.com\", \"password\": \"12345678\"}",
            "{\"name\": \"saul\", \"email\": \"saul@gmail.com\", \"password\": \"12345678\"}"

    };

    @Test
    public void badRequest() throws  Exception{
        for (String body:fieldData) {

            mockMvc.perform(post("/user").content(body).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());


        }
    }


    @Test
   public void getUser() throws Exception {
    mockMvc.perform(get("/user"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isArray());



    }


    @Test
    void testCreateUser() throws Exception {
        String body = "{\"name\": \"saul\", \"lastName\": \"burgos\",\"email\": \"saul@gmail.com\", \"password\": \"12345678\"}";

        mockMvc.perform(post("/user").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string(""))
        ;

    }






}