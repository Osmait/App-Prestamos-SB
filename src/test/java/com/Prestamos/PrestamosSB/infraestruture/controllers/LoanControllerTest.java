package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;
import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.*;
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
    private ClientRepository clientRepository;

    private User user;
    private  String token;

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
      token =jwtService.generateToken(user);
        clientRepository.save(client1);
    }

//    @AfterEach
//    void setDown(){
//        clientRepository.deleteAll();
//        userRepository.deleteAll();
//    }

    @Test
    void getAllLoanByClientId() throws Exception {

        mockMvc.perform(get("/loan/1").header("Authorization","Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void createLoan() throws Exception {


       Client client = clientRepository.findById(1L).orElseThrow();

        System.out.println(client);
        String body = "{\"amount\": \"1500.00\", \"clientId\": \"1\"}";
        mockMvc.perform(post("/loan").header("Authorization","Bearer " + token).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}