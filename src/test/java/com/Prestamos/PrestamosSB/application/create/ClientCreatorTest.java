package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;

import com.Prestamos.PrestamosSB.domain.User;
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

    @MockBean
    private  AuthService authService;


    @Test
    void create() throws Exception {
        User user = User.builder().email("saulburgos6@gmail.com").name("saul").lastName("burgos").password("12345678").build();

        Client client = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("12345678")
                .build();
        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        clientCreator.create(client);

        Mockito.verify(clientRepository,Mockito.times(1)).save(client);



    }
}