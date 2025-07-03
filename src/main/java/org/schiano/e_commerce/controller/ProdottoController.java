package org.schiano.e_commerce.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.dto.ProdottoDTO;
import org.schiano.e_commerce.dto.RimuoviProdottoDTO;
import org.schiano.e_commerce.error.exceptions.NessunRisultatoException;
import org.schiano.e_commerce.model.Categoria;
import org.schiano.e_commerce.service.definition.CategoriaService;
import org.schiano.e_commerce.service.definition.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Tag(
		name = "Prodotti", 
		description = "Gestione dei prodotti: visualizzazione, inserimento e rimozione"
	)


@RestController
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoS;

    @Autowired
    private CategoriaService categoriaS;

    @Operation(
        summary = "Inserisce un nuovo prodotto (Admin)",
        description = "Riceve un oggetto contenente i dati di un nuovo prodotto e l'ID di una categoria esistente. "
                    + "Se la categoria esiste, il prodotto viene inserito e viene restituito stato 200. "
                    + "Se i dati sono incompleti o la categoria non esiste, viene restituito errore."
    )
    
    @PostMapping("/admin/inserisci")
    public ResponseEntity<Void> inserisciProdotto(@RequestBody NuovoProdottoDTO prodotto) {
    	System.out.println("✅ SONO ENTRATO NEL CONTROLLER: /admin/inserisci");
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        Categoria cat = categoriaS.getById(prodotto.getCategoria_id());
        prodottoS.insert(prodotto, cat);
        return ResponseEntity.ok().build();
    }

    
    
    

    @Operation(
        summary = "Rimuove un prodotto (Admin)",
        description = "Riceve l'ID di un prodotto da eliminare. Se il prodotto esiste viene rimosso, "
                    + "altrimenti viene restituito un errore 404."
    )
    @ApiResponses(
    		value = {
    				@ApiResponse(responseCode = "200", description = "Prodotto rimosso con successo"),
    				@ApiResponse(responseCode = "404", description = "Prodotto non trovato")
    				}
    		)
    
    @DeleteMapping("/admin/rimuovi")
    public ResponseEntity<Void> rimuoviProdotto(@Valid @RequestBody RimuoviProdottoDTO prod) {
        try {
            prodottoS.delete(prod.getId());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
    	summary = "Visualizza tutti i prodotti",
        description = "Restituisce una lista di tutti i prodotti disponibili. "
                    + "Se non è presente alcun prodotto, viene restituito errore 404 con un messaggio personalizzato."
    )
    @ApiResponses(
    		value = {
    				@ApiResponse(responseCode = "200", description = "Lista di prodotti restituita con successo"),
    				@ApiResponse(responseCode = "404", description = "Nessun prodotto disponibile")
    				}
    		)
    
    @GetMapping("/utente/visualizza")
    public ResponseEntity<List<ProdottoDTO>> getAllProdotti() throws NessunRisultatoException {
    	System.out.println("✅ SONO ENTRATO NEL CONTROLLER: /utente/visualizza");

    	List<ProdottoDTO> prodotti = prodottoS.getAllDTO();

        if (prodotti == null || prodotti.isEmpty()) {
            throw new NessunRisultatoException("Nessun prodotto disponibile al momento.");
        }

        return ResponseEntity.ok(prodotti);
    }
    
    
    
    
    
    
    
    
    
    
    
}
