package com.Prestamos.PrestamosSB.application.create;


import com.Prestamos.PrestamosSB.application.find.FindUser;
import com.Prestamos.PrestamosSB.domain.User.User;

import com.Prestamos.PrestamosSB.domain.User.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserCreator {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final FindUser findUser;




    public void create(User user )  {





        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);

        userRepository.save(user);


    }
}
