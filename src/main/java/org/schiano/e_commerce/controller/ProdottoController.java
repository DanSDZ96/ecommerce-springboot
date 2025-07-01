package org.schiano.e_commerce.controller;

import java.util.List;

import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.dto.ProdottoDTO;
import org.schiano.e_commerce.dto.RimuoviProdottoDTO;
import org.schiano.e_commerce.model.Categoria;
import org.schiano.e_commerce.service.definition.CategoriaService;
import org.schiano.e_commerce.service.definition.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoS;

    @Autowired
    private CategoriaService categoriaS;

    @PostMapping("/admin/inserisci")
    public ResponseEntity<Void> inserisciProdotto(@Valid @RequestBody NuovoProdottoDTO prodotto) {
        try {
            Categoria cat = categoriaS.getById(prodotto.getCategoria_id());
            prodottoS.insert(prodotto, cat);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
        	 e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/admin/rimuovi")
    public ResponseEntity<Void> rimuoviProdotto(@RequestBody RimuoviProdottoDTO prod) {
    	try {
    		prodottoS.delete(prod.getId());
    		return ResponseEntity.ok().build();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.notFound().build();
    	}
    }
    
    
    
    @GetMapping("/visualizza")
    public ResponseEntity<List<ProdottoDTO>> getAllProdotti() {
        List<ProdottoDTO> prodotti = prodottoS.getAllDTO();
        return ResponseEntity.ok(prodotti);
    }
    
    
    
    
    
    
    
    
    
}
