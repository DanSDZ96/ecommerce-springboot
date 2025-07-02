package org.schiano.e_commerce.controller;

import org.schiano.e_commerce.dto.InserimentoCategoriaDTO;
import org.schiano.e_commerce.service.definition.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Tag(
		name = "Gestione della Categoria", 
		description = "Operazioni riservate alla gestione delle categorie"
	 )

@RestController
@RequestMapping("/admin/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Operation(
    	summary = "Inserisce una nuova categoria",		//spiega brevemente cosa fa l'endpoint
        description = "Endpoint disponibile solo per amministratori. "	//spiegazione dettagliata
        		+ "Riceve i dati di una nuova categoria nel body della richiesta e la salva nel sistema. "
        		+ "In caso di dati mancanti o errati viene restituito un errore 400."
    		)
    
    @ApiResponses(
    		value = {
    				@ApiResponse(responseCode = "200", description = "Categoria inserita correttamente"),
    				@ApiResponse(responseCode = "400", description = "Dati non validi")
    				}
    			)
    @PostMapping("/insert")
    public ResponseEntity<Void> inserisciCategoria(@RequestBody InserimentoCategoriaDTO categoria) {
        try {
            categoriaService.insert(categoria);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
