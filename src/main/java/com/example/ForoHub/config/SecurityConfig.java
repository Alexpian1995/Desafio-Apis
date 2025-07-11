package com.example.ForoHub.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // ❌ Desactiva CSRF temporalmente
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // ✅ Permite todas las peticiones sin login
                )
                .build();
    }


}
