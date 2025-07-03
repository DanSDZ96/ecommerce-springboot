package org.schiano.e_commerce.controller;

import org.schiano.e_commerce.dto.InsertUtenteDTO;
import org.schiano.e_commerce.service.definition.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
		name = "Utenti",
		description = "Gestione utenti"
		)


@RestController
public class UtenteController {
	
	@Autowired
	private UtenteService utenteS;

	 @ApiResponses(
	    		value = {
	    				@ApiResponse(responseCode = "200", description = "Utente aggiunto con successo"),
	    				@ApiResponse(responseCode = "500", description = "Errore")
	    				}
	    		)
	@PostMapping("/registrazione")
	public ResponseEntity<Void> nuovoUtente(@RequestBody InsertUtenteDTO utente) {
		utenteS.save(utente);
		return ResponseEntity.ok().build();
	}
	
}
