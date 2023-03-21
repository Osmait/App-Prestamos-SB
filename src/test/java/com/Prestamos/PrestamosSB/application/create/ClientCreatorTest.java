package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



@SpringBootTest
@Transactional
class ClientCreatorTest {

    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private  ClientCreator clientCreator;



    @Test
    void create() {

        Client client = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("12345678")
                .build();
        clientCreator.create(client);

        Mockito.verify(clientRepository,Mockito.times(1)).save(client);



    }
}