package com.Prestamos.PrestamosSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class PrestamosSbApplication {


	public static void main(String[] args) {
		SpringApplication.run(PrestamosSbApplication.class, args);
	}



}
