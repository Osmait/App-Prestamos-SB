package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.ClientCreator;
import com.Prestamos.PrestamosSB.application.find.FindClient;
import com.Prestamos.PrestamosSB.domain.Client;

import com.Prestamos.PrestamosSB.infraestruture.Dto.ClientDto;
import com.Prestamos.PrestamosSB.infraestruture.utils.ValidateBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ClientController {

    private final ClientCreator clientCreator;
    private final FindClient findClient;


    @GetMapping("/client")
    public ResponseEntity<List<Client>>getClient(){

        List<Client> clientList = findClient.findAllClientByUserId();
        System.out.println(clientList);
        return new ResponseEntity<>(clientList, HttpStatus.OK);

    }

    @PostMapping("/client")
    public ResponseEntity<Map<String, String>> createClient(@Validated @RequestBody ClientDto clientRequest, BindingResult result){
        if (result.hasErrors()){

         return ValidateBody.ValidFilds(result);
        }


        Client client = clientRequest.getClientFromDto();
        clientCreator.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<HttpStatus>deleteClient(@PathVariable Long id){
        findClient.findAndDeleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
