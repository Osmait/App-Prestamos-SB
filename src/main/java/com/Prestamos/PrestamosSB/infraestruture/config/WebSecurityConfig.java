package com.Prestamos.PrestamosSB.infraestruture.config;


import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.DelegatedAuthEntryPoint;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;


import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig  {


    private final JwtRequestFilter JwtRequestFilter;
    private final DelegatedAuthEntryPoint delegatedAuthEntryPoint;



    private final AuthenticationProvider authenticationProvider;



    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers( HttpMethod.POST,"/user/**").permitAll()
                .requestMatchers("/health-check").permitAll()
                .requestMatchers("/login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(
                        JwtRequestFilter,
                        UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(delegatedAuthEntryPoint);
         return http.build();

    }


}
