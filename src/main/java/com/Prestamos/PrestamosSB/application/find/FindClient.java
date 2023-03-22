package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;
import com.Prestamos.PrestamosSB.domain.User;
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

    private final AuthService authService;


    public  Client findCLientById(Long id){

        Client client =  clientRepository.findById(id).orElseThrow();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(client);
        return client;
    }
    public  List<Client>findAllClientByUserId(){

        Long currentUserId =  authService.getIdCurrentLoggedUser().getId();
        List<Client> list = new ArrayList<>();

    try{
        clientRepository.findAllByUserId(currentUserId).iterator().forEachRemaining(list::add);
    }catch (Exception e){
        System.out.println("Error al buscar clients");
    }


    return list;



    }
}
