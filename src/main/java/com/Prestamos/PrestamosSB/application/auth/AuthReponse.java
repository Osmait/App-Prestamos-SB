package com.Prestamos.PrestamosSB.application.auth;


import lombok.Data;


public class AuthReponse {
    private String token;

    public AuthReponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthReponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
