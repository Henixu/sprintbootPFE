package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for development purposes
                .authorizeRequests()
                .requestMatchers("/auth/register", "/auth/login","/admin/trainings/create","/admin/trainings/update/**","/admin/trainings/delete/*").permitAll() // Public access for these endpoints
                .anyRequest().authenticated() // All other endpoints require authentication
                .and()
                .sessionManagement().disable();
        return http.build();
    }
}