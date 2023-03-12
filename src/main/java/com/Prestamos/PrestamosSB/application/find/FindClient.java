package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindClient {

    @Autowired
    private ClientRepository clientRepository;

    public  List<Client>findAllClient(){
        List<Client> listClient = new ArrayList<>();
        clientRepository.findAll().iterator().forEachRemaining(listClient::add);
        return listClient;
    }
}
