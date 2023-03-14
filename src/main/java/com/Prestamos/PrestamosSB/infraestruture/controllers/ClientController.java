package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.ClientCreator;
import com.Prestamos.PrestamosSB.application.find.FindClient;
import com.Prestamos.PrestamosSB.domain.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private ClientCreator clientCreator;
    private FindClient findClient;

    public ClientController(ClientCreator clientCreator, FindClient findClient) {
        this.clientCreator = clientCreator;
        this.findClient = findClient;
    }

    @GetMapping("/client")
    public ResponseEntity<List<Client>>getClient(){
        List<Client> clientList = findClient.findAllClient();
        return new ResponseEntity<>(clientList, HttpStatus.OK);

    }
}
