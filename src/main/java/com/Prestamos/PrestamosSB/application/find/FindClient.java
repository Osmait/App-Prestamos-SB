package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClient {


    private final ClientRepository clientRepository;

    private final AuthService authService;


    public  Client findClientById(Long id){

        return clientRepository.findById(id).orElseThrow();
    }


    public  List<Client>findAllClientByUserId(){

        Long currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UsernameNotFoundException("User Not Auth");
        }
        List<Client> list = new ArrayList<>();

        try{
            clientRepository.findAllByUserId(currentUserId).iterator().forEachRemaining(list::add);

        }catch (Exception e){

            throw new ArrayStoreException("Error find client");
        }

        return list;
    }


    public void findAndDeleteById(Long id){
        clientRepository.deleteById(id);
    }
}
