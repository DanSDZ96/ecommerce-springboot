package org.schiano.e_commerce.controller;

import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.service.definition.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {
	
	@Autowired
	private ProdottoService prodottoS;
	
	@PostMapping("/admin/insert")
	public ResponseEntity<Void> inserisciProdotto(@RequestBody NuovoProdottoDTO prodotto){
		try {
			prodottoS.insert(prodotto);
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	

}
