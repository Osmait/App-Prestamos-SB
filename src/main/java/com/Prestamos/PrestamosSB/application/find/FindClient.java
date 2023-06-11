package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Client.Client;
import com.Prestamos.PrestamosSB.domain.Client.ClientRepository;

import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindClient {


    private final ClientRepository clientRepository;

    private final AuthService authService;


    public  Client findClientById(UUID id){

        return clientRepository.findById(id).orElseThrow( () -> new NotFoundException("Client Not Found"));
    }


    public  List<Client>findAllClientByUserId() {

        UUID currentUserId =  authService.getIdCurrentLoggedUser().getId();
        System.out.println(currentUserId.toString());
        if (currentUserId == null){
            throw new UsernameNotFoundException("User Not Auth");
        }

           return  clientRepository.findAllByUserId(currentUserId).orElseThrow();
    }

    public void findAndDeleteById(UUID id){
        clientRepository.deleteById(id);
    }
}
