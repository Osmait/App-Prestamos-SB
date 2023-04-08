package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.application.find.FindUser;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientCreator {


    private final ClientRepository clientRepository;
    private final FindUser findUser;



    private final AuthService authService;

    public  void  create(Client client) throws Exception{

       String currentUserId =  authService.getIdCurrentLoggedUser().getEmail();
        System.out.println(currentUserId);


       client.setUser(findUser.findByEmail(currentUserId));
        System.out.println(client);


       try{
           clientRepository.save(client);
       }catch (Exception e ){

           throw  new Exception();

       }

    }
}
