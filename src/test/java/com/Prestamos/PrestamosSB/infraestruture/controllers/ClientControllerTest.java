package com.Prestamos.PrestamosSB.infraestruture.controllers;


import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;
import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import com.Prestamos.PrestamosSB.infraestruture.config.JwtService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private JwtService jwtService;

   private User user;



    @BeforeEach
    void setUp(){


        user =User.builder().email("saulburgos6@gmail.com").name("saul").lastName("burgos").password("12345678").build();
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        Client client1 = Client.builder()
                .name("joseSAul")
                .lastName("burgos")
                .email("saulburgos7@gmail.com")
                .phoneNumber("80945783454")
                .user(user)
                .build();
        clientRepository.save(client1);
    }

    @AfterEach
    void setDown(){
        clientRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    void getClient() throws Exception {
    String token =jwtService.generateToken(user);


        mockMvc.perform(get("/client/1").header("Authorization","Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"name\": \"joseSAul\", \"lastName\": \"burgos\",\"email\": \"saulburgos7@gmail.com\", \"phoneNumber\": \"80945783454\"}]"));


    }

    @Test
    void createClient() throws Exception {
        String token =jwtService.generateToken(user);

        String body = "{\"name\": \"saul\", \"lastName\": \"burgos\",\"email\": \"saul10@gmail.com\", \"password\": \"12345678\"}";
        mockMvc.perform(post("/client").header("Authorization","Bearer " + token).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}
