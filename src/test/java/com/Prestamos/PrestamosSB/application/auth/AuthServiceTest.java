package com.Prestamos.PrestamosSB.application.auth;

import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import com.Prestamos.PrestamosSB.infraestruture.config.JwtService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.Optional;

@SpringBootTest

class AuthServiceTest {


    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private JwtService jwtService;
    @Autowired
    private  AuthService authService;



    @Test
    void authenticate() {
        AuthRequest request = AuthRequest.builder().email("prueba@gmail.com").password("123456").build();
        User user = User.builder().email("saulburgos6@gmail.com").name("saul").lastName("burgos").password("12345678").build();
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

        Mockito.when(userRepository.findOneByEmail(request.getEmail())).thenReturn(Optional.of(user));
        Mockito.when(jwtService.generateToken(user)).thenReturn(token);

        AuthReponse response =  authService.authenticate(request);

        assertNotNull(response.getToken());
        assertEquals(token,response.getToken());






    }
}