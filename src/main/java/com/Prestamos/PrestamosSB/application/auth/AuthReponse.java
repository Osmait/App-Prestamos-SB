package com.Prestamos.PrestamosSB.application.auth;


import lombok.Data;

@Data
public class AuthReponse {
    private String token;

    public AuthReponse(String token) {
        this.token = token;
    }



}
