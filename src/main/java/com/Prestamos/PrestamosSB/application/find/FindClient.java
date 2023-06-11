package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Client.Client;
import com.Prestamos.PrestamosSB.domain.Client.ClientRepository;

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

        return clientRepository.findById(id).orElseThrow();
    }


    public  List<Client>findAllClientByUserId() throws Exception {

        UUID currentUserId =  authService.getIdCurrentLoggedUser().getId();
        System.out.println(currentUserId.toString());
        if (currentUserId == null){
            throw new UsernameNotFoundException("User Not Auth");
        }

        try{

           return  clientRepository.findAllByUserId(currentUserId).orElseThrow();

        }catch (Exception e){

            throw new Exception(e);
        }

    }



    public void findAndDeleteById(UUID id){
        clientRepository.deleteById(id);
    }
}
