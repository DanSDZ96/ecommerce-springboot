package org.schiano.e_commerce.model;

import lombok.Getter;

@Getter
public enum Ruolo {
    UTENTE("UTENTE"),
    ADMIN("ADMIN");

    private final String name;

    Ruolo(String name) {
        this.name = name;
    }
}
