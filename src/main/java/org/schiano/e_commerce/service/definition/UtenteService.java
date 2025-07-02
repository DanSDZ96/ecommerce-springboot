package org.schiano.e_commerce.service.definition;


import org.schiano.e_commerce.dto.InsertUtenteDTO;
import org.schiano.e_commerce.dto.UtenteDTO;
import org.schiano.e_commerce.model.Utente;

public interface UtenteService extends GeneralService<Utente> {
	
	UtenteDTO save(InsertUtenteDTO utenteDTO);


}
