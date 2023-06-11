package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.domain.Client.Client;
import com.Prestamos.PrestamosSB.domain.Client.ClientRepository;
import com.Prestamos.PrestamosSB.domain.User.User;
import UserRepository;

import com.Prestamos.PrestamosSB.infraestruture.config.JwtService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private  ClientRepository clientRepository;

    private  User userLoan;

    @BeforeEach
    void setUp(){
        userLoan =User.builder()

                .email("saulburgos8@gmail.com")
                .name("saul")
                .lastName("burgos")
                .password("12345678")
                .build();
        userLoan.setPassword(new BCryptPasswordEncoder().encode(userLoan.getPassword()));
        userRepository.save(userLoan);


    }

    @AfterEach
    void setDown(){
        clientRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
   public void createLoan() throws Exception {
      User userDb =   userRepository.findOneByEmail(userLoan.getEmail()).orElseThrow();
      Client client434465 = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos42@gmail.com")
                .phoneNumber("12345678")
                .user(userDb)
                .build();

        clientRepository.save(client434465);
       List<Client>clientDb =  clientRepository.findAllByUserId(userDb.getId()).orElseThrow();


        String  tokenL =jwtService.generateToken(userLoan);
        String body = String.format("{\n" +
                "    \"amount\":\"2000\",\n" +
                "    \"interest\":20,\n" +
                "    \"amountOfPayments\":6,\n" +
                "    \"paymentDate\":\"2023-04-08T07:00:00.000Z\",\n" +
                "    \"clientId\":%s\n" +
                "\n" +
                "}",clientDb.get(0).getId());
        mockMvc.perform(post("/loan")
                        .header("Authorization","Bearer " + tokenL)
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
  public void getAllLoan() throws Exception {
      String  token23 =jwtService.generateToken(userLoan);
        mockMvc.perform(get("/loan/1").header("Authorization","Bearer " + token23))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }


}