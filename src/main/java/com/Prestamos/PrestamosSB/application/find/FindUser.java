package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import com.Prestamos.PrestamosSB.infraestruture.Dto.UserDto;
import com.Prestamos.PrestamosSB.infraestruture.Dto.UserResponse;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.UnAuthorizedException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindUser {


    private final UserRepository userRepository;

    private final AuthService authService;

    public List<UserResponse>findAllUser(){
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);

        return list.stream().map(user -> new UserResponse(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getCreateAt()
        )).toList();
    }

    public User findByEmail(String email){
        return userRepository.findOneByEmail(email).orElse(new User());
    }

    public User findProfile(){
        Long currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UnAuthorizedException("User Not Auth");
        }

        return userRepository.findById(currentUserId).orElseThrow( ()-> new RuntimeException("User not found"));
    }
}
