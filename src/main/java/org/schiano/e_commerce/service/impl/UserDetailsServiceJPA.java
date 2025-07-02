package org.schiano.e_commerce.service.impl;

import org.schiano.e_commerce.model.Utente;
import org.schiano.e_commerce.repository.UtenteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserDetailsServiceJPA implements UserDetailsService{
	private final UtenteRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Utente user = repository.findByUsername(username);
	    if (user == null) {
	        throw new UsernameNotFoundException("User non trovato con l'username " + username);
	    }
	    return user;
	}

}
