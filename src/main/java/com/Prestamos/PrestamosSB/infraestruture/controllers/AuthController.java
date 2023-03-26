package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.auth.AuthReponse;
import com.Prestamos.PrestamosSB.application.auth.AuthRequest;
import com.Prestamos.PrestamosSB.application.auth.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;



    @PostMapping("/login")
    public ResponseEntity<AuthReponse>autenticate(
            @RequestBody AuthRequest request
            ){
        return  ResponseEntity.ok(authService.authenticate(request));
    }




}
