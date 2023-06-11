package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Client.Client;
import com.Prestamos.PrestamosSB.domain.Client.ClientRepository;

import com.Prestamos.PrestamosSB.domain.User.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientCreator {


    private final ClientRepository clientRepository;




    private final AuthService authService;

    public  void  create(Client client) throws Exception{

       User currentUserId =  authService.getIdCurrentLoggedUser();

       client.setUser(currentUserId);

       clientRepository.save(client);


    }
}
