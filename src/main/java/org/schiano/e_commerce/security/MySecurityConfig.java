package org.schiano.e_commerce.security;

import org.schiano.e_commerce.model.Ruolo;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MySecurityConfig {

    private final MySecurityFilter mySecurityFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeHttpRequests(auth -> {
              auth.requestMatchers("/utente/**").authenticated();
              auth.requestMatchers("/admin/**").hasRole(Ruolo.ADMIN.name());
              auth.anyRequest().permitAll();
          })
          .csrf(csrf -> csrf.disable());

        http.addFilterBefore(mySecurityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
