package com.Prestamos.PrestamosSB.application.find;


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
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FindClientTest {
    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private FindClient findClient;

    @MockBean
    private AuthService authService;

    @Test
    void findAllClient() {
        List<Client> clientList = new ArrayList<>();
       User user = User.builder().id(1L).email("saulburgos6@gmail.com").name("saul").lastName("burgos").password("12345678").build();

        Client client1 = Client.builder()
                .name("joseSAul")
                .lastName("burgos")
                .email("saulburgos7@gmail.com")
                .phoneNumber("80945783454")
                .user(user)
                .build();

        Client client2 = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("80945323454")
                .user(user)
                .build();

        clientList.add(client1);
        clientList.add(client2);

        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        Mockito.when(clientRepository.findAllByUserId(1L)).thenReturn(clientList);


        List<Client> result = findClient.findAllClientByUserId();
        assertEquals(clientList.size(),result.size());
        assertEquals(clientList.get(0), result.get(0));
        assertEquals(clientList.get(1), result.get(1));


    }

    @Test
    void findAndDeleteById() {
//        Client client = Client.builder()
//                .name("saul")
//                .lastName("burgos")
//                .email("saulburgos6@gmail.com")
//                .phoneNumber("12345678")
//                .build();

        clientRepository.deleteById(1L);

        Mockito.verify(clientRepository,Mockito.times(1)).deleteById(1L);

    }
}