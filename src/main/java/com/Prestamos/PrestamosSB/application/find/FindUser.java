package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindUser {


    private final UserRepository userRepository;

    private final AuthService authService;

    public List<User>findAllUser(){
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        System.out.println(list);
        return list;
    }

    public User findByEmail(String email){
        return userRepository.findOneByEmail(email).orElse(new User());
    }

    public User findProfile(){
        Long currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UsernameNotFoundException("User Not Auth");
        }

        return userRepository.findById(currentUserId).orElse(new User());
    }
}
