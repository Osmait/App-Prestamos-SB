package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientCreator {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AuthService authService;

    public  void  create(Client client){

       Long currentUserId =  authService.getIdCurrentLoggedUser();

       client.setUserId(currentUserId);

       try{
           clientRepository.save(client);
       }catch (Exception e ){
           System.out.println("Error Insert Client In dataBase");
       }

    }
}
