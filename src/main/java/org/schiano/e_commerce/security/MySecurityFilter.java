package org.schiano.e_commerce.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor

//Filtro custom per il processo di autenticazione

public class MySecurityFilter extends OncePerRequestFilter {	//l'extend fa in modo che il filtro venga eseguito una volta per request
	

    private final PasswordEncoder passwordEncoder;			//controllo sulle credenziali
    private final UserDetailsService userDetailsService;	//prende info utente dal DB

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) 
                                    throws ServletException, IOException {
    	
        SecurityContext securityContext = SecurityContextHolder.getContext();		//il securityContext contiene le info sull'autenticazione dell'utente
        					
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        
        System.out.println("🔍 Tentativo di login con username: " + username + " e password: " + password);
        if (username == null || password == null || securityContext.getAuthentication() != null) {
            filterChain.doFilter(request, response);
            return;
        }
        
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        System.out.println("🎯 Trovato utente nel DB: " + userDetails.getUsername());
        System.out.println("🧂 Password criptata nel DB: " + userDetails.getPassword());
      
//        
//        if (userDetails == null) {
//            filterChain.doFilter(request, response);
//            return;
//        }
        
        if( !passwordEncoder.matches(password, userDetails.getPassword())) {
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
        	        userDetails, null, userDetails.getAuthorities()
        	    );


        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);
System.out.println("✅ Autenticato come: " + userDetails.getUsername() + " con ruoli: " + userDetails.getAuthorities());

        filterChain.doFilter(request, response);
    }








}