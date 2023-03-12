package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientCreator {

    @Autowired
    private ClientRepository clientRepository;

    public  void  create(Client client){
        clientRepository.save(client);
    }
}
