package com.Prestamos.PrestamosSB.application.create;


import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public UserCreator(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void create( User user){
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);

        try {
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
