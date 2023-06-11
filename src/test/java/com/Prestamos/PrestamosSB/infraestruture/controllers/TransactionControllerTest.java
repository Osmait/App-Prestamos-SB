package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.domain.Client.Client;
import com.Prestamos.PrestamosSB.domain.Client.ClientRepository;
import com.Prestamos.PrestamosSB.domain.Loan.Loan;
import com.Prestamos.PrestamosSB.domain.Loan.LoanRepository;
import com.Prestamos.PrestamosSB.domain.User.User;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
                .email("saulburgos7@gmail.com")
                .name("saul")
                .lastName("burgos")
                .password("12345678")
                .build();

        userT.setPassword(new BCryptPasswordEncoder().encode(userT.getPassword()));
        userRepository.save(userT);


        Client client4563 = Client.builder()
                .name("jose")
                .lastName("burgos")
                .email("saulburgos689@gmail.com")
                .phoneNumber("12345678")
                .user(userT)
                .build();
        clientRepository.save(client4563);
        Loan prestamo =Loan.builder().amount(100.00).client(client4563).PaymentDate(LocalDateTime.parse("2023-04-08T04:00:00.000Z", DateTimeFormatter.ISO_DATE_TIME)).amountOfPayments(6).interest(20.00).user(userT).build();

        prestamoRepository.save(prestamo);
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
        User userDb =   userRepository.findOneByEmail(userT.getEmail()).orElseThrow();
        System.out.println(userDb);
        List<Loan> loanDb =  prestamoRepository.findAllByUserId(userDb.getId()).orElseThrow();
        System.out.println(loanDb);

        String token = jwtService.generateToken(userT);
        String body =String.format( "{\n" +
                "    \"amount\": \"1000.00\",\n" +
                "    \"transactionType\":\"pay\",\n" +
                "    \"loanId\": \"%s\"\n" +
                "}",loanDb.get(0).getId());
        mockMvc.perform(post("/transaction")
                        .header("Authorization","Bearer " + token)
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}