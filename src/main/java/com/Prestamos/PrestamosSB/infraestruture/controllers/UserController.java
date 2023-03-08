package com.Prestamos.PrestamosSB.infraestruture.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/user")
    public ResponseEntity<String> getUser(){
        return new ResponseEntity<>("users", HttpStatus.OK);

    }

//    @PostMapping("/user")
//    public ResponseEntity<HttpStatus> createUser(){
//        return new ResponseEntity<>(HttpStatus.CREATED);
//
//    }
}
