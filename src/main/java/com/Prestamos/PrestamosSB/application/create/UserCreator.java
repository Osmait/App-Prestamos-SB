package com.Prestamos.PrestamosSB.application.create;


import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserCreator {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;




    public void create( User user){
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);
        try {
            userRepository.save(user);
        }catch (Exception e){
            System.out.println("Error Insert User");
        }

    }
}
