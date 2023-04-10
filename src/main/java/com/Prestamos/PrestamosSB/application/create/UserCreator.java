package com.Prestamos.PrestamosSB.application.create;


import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserCreator {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;




    public void create( User user) throws Exception {

      boolean emailDb =   userRepository.findOneByEmail(user.getEmail()).isEmpty();

      if (!emailDb){
          throw new Exception("Email Take");
      }

        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);
        try {
            userRepository.save(user);
        }catch (Exception e){
            throw  new Exception(e);
        }

    }
}
