package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindUser {


    private final UserRepository userRepository;

    public List<User>findAllUser(){
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public User findByEmail(String email){
        return userRepository.findOneByEmail(email).orElseThrow();
    }
}
