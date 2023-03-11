package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.UserCreator;
import com.Prestamos.PrestamosSB.application.find.FindUser;
import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.infraestruture.Dto.UserDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    private final UserCreator userCreator;
    private final FindUser findUser;

    public UserController(UserCreator userCreator, FindUser findUser) {
        this.userCreator = userCreator;
        this.findUser = findUser;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUser(){
       List<User> userList =  findUser.findAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);

    }

    @PostMapping("/user")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDto user){
        User newUser =  user.getUserFromDto();
        userCreator.create(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
