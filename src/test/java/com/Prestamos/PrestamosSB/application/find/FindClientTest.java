package com.Prestamos.PrestamosSB.application.find;


import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FindClientTest {
    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private FindClient findClient;

    @Test
    void findAllClient() {
        List<Client> clientList = new ArrayList<>();

        Client client1 = new Client("joseSAul", "burgos","saulburgos7@gmail.com","80945783454",1L);

        Client client2 = new Client("saul", "burgos","saulburgos6@gmail.com","80945323454",1L);
        clientList.add(client1);
        clientList.add(client2);

        Mockito.when(clientRepository.findAll()).thenReturn(clientList);

        List<Client> result = findClient.findAllClient();
        assertEquals(clientList.size(),result.size());
        assertEquals(clientList.get(0), result.get(0));
        assertEquals(clientList.get(1), result.get(1));


    }
}