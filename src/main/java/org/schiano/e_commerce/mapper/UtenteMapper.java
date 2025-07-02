package org.schiano.e_commerce.mapper;

import org.schiano.e_commerce.dto.InsertUtenteDTO;
import org.schiano.e_commerce.dto.UtenteDTO;
import org.schiano.e_commerce.model.Utente;

public class UtenteMapper {

    public static Utente fromInsertUtenteDTO(InsertUtenteDTO dto) {
        Utente u = new Utente();
        u.setUsername(dto.getUsername());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        return u;
    }

    public static UtenteDTO toUtenteDTO(Utente utente) {
        UtenteDTO dto = new UtenteDTO();
        dto.setId(utente.getId());
        dto.setUsername(utente.getUsername());
        dto.setEmail(utente.getEmail());

        // Altri campi possono restare null
        dto.setOrdineDTO(null);
        dto.setRecensioniDTO(null);
        dto.setCarrelloDTO(null);

        return dto;
    }
}
