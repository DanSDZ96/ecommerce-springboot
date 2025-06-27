package org.schiano.e_commerce.controller;

import org.schiano.e_commerce.dto.InserimentoCategoriaDTO;
import org.schiano.e_commerce.service.definition.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/categoria")		//URL comune ad ogni funzione
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@PostMapping("/insert")
	public ResponseEntity<Void> inserisciCategoria(@RequestBody InserimentoCategoriaDTO categoria){
		try {
			categoriaService.insert(categoria);
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().build();
			
		}
		
	}
	
	

}
