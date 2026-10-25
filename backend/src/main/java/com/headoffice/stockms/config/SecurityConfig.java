package com.headoffice.stockms.common.config;

import org.springframework.context.annotaion.Bean;
import org.springframework.contect.annotation.configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .csrf(csrf ->csrf.disable());
            .authorizeHttpRequest(auth -> auth
                .requestMatchers("/api/users/**","/swagger-ui/**","/v3/api-docs/**").permitAll()
                .anyRquests().authenticated()
            );
            return http.build();
        }

    }



}