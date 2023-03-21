package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClient {


    private final ClientRepository clientRepository;




    public  Client findCLientById(Long id){

        Client client =  clientRepository.findById(id).orElseThrow();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(client);
        return client;
    }
    public  List<Client>findAllClientByUserId(Long id){
        List<Client> list = new ArrayList<>();

    try{
        clientRepository.findAllByUserId(id).iterator().forEachRemaining(list::add);
    }catch (Exception e){
        System.out.println("Error al buscar clients");
    }


    return list;



    }
}
