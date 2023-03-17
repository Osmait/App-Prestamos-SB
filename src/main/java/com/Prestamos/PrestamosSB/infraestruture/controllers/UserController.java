package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.UserCreator;
import com.Prestamos.PrestamosSB.application.find.FindUser;
import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.infraestruture.Dto.UserDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserCreator userCreator;
    private final FindUser findUser;



    @GetMapping("/user")
    public ResponseEntity<List<User>> getUser(){
       List<User> userList =  findUser.findAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);

    }

    @PostMapping("/user")
    public ResponseEntity<Map<String, String>> createUser(@Validated @RequestBody UserDto user, BindingResult result){
        if(result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for(FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        User newUser =  user.getUserFromDto();
        userCreator.create(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
