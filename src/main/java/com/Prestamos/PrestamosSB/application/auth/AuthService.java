package com.Prestamos.PrestamosSB.application.auth;


import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import com.Prestamos.PrestamosSB.infraestruture.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final AuthenticationManager authenticationManager;


    private final UserRepository userRepository;


    private final JwtService jwtService;



    public AuthReponse authenticate(AuthRequest request){
        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        User user = userRepository.findOneByEmail(request.getEmail()).orElseThrow();

        String token = jwtService.generateToken(user);

        return new AuthReponse(token);
    }

    public  Long getIdCurrentLoggedUser(){
        Authentication auth  = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()){
            return  null;
        }
        return ((User) auth.getPrincipal()).getId();
    }
}
