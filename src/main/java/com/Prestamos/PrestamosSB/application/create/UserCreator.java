package com.Prestamos.PrestamosSB.application.create;


import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCreator {

    @Autowired
    private UserRepository userRepository;

    public void create( User user){
        userRepository.save(user);
    }
}
