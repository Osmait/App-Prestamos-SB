package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.domain.*;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LoanRepository prestamoRepository;

    @Autowired
    private JwtService jwtService;

    private User userT;


    @BeforeEach
    void setUp(){
        userT = User.builder()
                .email("saulburgos66@gmail.com")
                .name("saul")
                .lastName("burgos")
                .password("12345678")
                .build();

        userT.setPassword(new BCryptPasswordEncoder().encode(userT.getPassword()));
        userRepository.save(userT);
    }

    @AfterEach
    void setDown(){

        userRepository.deleteAll();

    }

    @Test
    void getTransactionByLoanId() throws Exception {
        String token304 = jwtService.generateToken(userT);
        mockMvc.perform(get("/transaction/1").header("Authorization","Bearer " + token304))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void createTransactions() throws Exception {
        Client client4563 = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos689@gmail.com")
                .phoneNumber("12345678")
                .user(userT)
                .build();
        clientRepository.save(client4563);
        Loan prestamo =Loan.builder().amount(100.00).client(client4563).build();

        prestamoRepository.save(prestamo);

        String token = jwtService.generateToken(userT);
        String body = "{\"amount\": \"1500.00\",\"transactionType\":\"pay\", \"loanId\": \"1\"}";
        mockMvc.perform(post("/transaction")
                        .header("Authorization","Bearer " + token)
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}