package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import com.Prestamos.PrestamosSB.infraestruture.config.JwtService;
import jakarta.transaction.Transactional;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    private User user;


    @BeforeEach
    void setUp(){
        user = User.builder()
                .email("saulburgos6@gmail.com")
                .name("saul")
                .lastName("burgos")
                .password("12345678")
                .build();

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);

    }

    @Test
    void createTransactions() throws Exception {
        String token = jwtService.generateToken(user);
        mockMvc.perform(get("/transaction/1").header("Authorization","Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getTransactionByLoanId() throws Exception {
        String token = jwtService.generateToken(user);
        String body = "{\"amount\": \"1500.00\",\"transactionType\":\"pay\", \"loanId\": \"1\"}";
        mockMvc.perform(post("/transaction").header("Authorization","Bearer " + token).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}