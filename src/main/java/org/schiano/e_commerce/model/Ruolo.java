package org.schiano.e_commerce.model;

import lombok.Getter;

@Getter
public enum Ruolo {
    UTENTE("UTENTE"),
    ADMIN("ADMIN");
	
	private final String nome;

	Ruolo(String nome) {
		this.nome = nome;
		
		
	}
}
