package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.UserCreator;
import com.Prestamos.PrestamosSB.application.find.FindUser;
import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.infraestruture.Dto.UserDto;

import com.Prestamos.PrestamosSB.infraestruture.Dto.UserResponse;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.BadRequest;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.DuplicateResourceException;
import com.Prestamos.PrestamosSB.infraestruture.utils.ValidateBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Objects;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {


    private final UserCreator userCreator;
    private final FindUser findUser;
    private final ValidateBody validateBody;




    @GetMapping("/user")
    public ResponseEntity<List<UserResponse>> getUser(){
       List<UserResponse> userList =  findUser.findAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);

    }

    @PostMapping("/user")
    public ResponseEntity<Map<String, String>> createUser(@Validated @RequestBody UserDto user, BindingResult result) {
        if(result.hasErrors()) {

            throw new BadRequest(validateBody.ValidFilds(result).toString());
        }

        User validate = findUser.findByEmail(user.getEmail());

        if (Objects.equals(validate.getEmail(), user.getEmail())){
            throw  new DuplicateResourceException("Email exits");
        }


        User newUser =  user.getUserFromDto();
        userCreator.create(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @GetMapping("/user/profile")
    public ResponseEntity<User> getUserById(){
        return new ResponseEntity<>(findUser.findProfile(),HttpStatus.OK);
    }
}
