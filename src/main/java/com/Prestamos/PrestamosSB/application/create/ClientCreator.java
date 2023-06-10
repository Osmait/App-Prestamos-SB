package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.application.find.FindUser;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.ClientRepository;

import com.Prestamos.PrestamosSB.domain.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientCreator {


    private final ClientRepository clientRepository;
//    private final FindUser findUser;



    private final AuthService authService;

    public  void  create(Client client) throws Exception{

       User currentUserId =  authService.getIdCurrentLoggedUser();

       client.setUser(currentUserId);

       clientRepository.save(client);


    }
}
