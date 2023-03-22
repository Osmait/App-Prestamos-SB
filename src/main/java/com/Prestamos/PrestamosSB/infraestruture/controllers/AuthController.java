package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.auth.AuthReponse;
import com.Prestamos.PrestamosSB.application.auth.AuthRequest;
import com.Prestamos.PrestamosSB.application.auth.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
