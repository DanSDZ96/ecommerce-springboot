package org.schiano.e_commerce.mapper;

import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.model.Categoria;
import org.schiano.e_commerce.model.Prodotto;
import org.springframework.stereotype.Component;

@Component
public class ProdottoMapper {
	
	public Prodotto fromNuovoProdottoDTO(NuovoProdottoDTO dto, Categoria categoria) {
	    Prodotto prod = new Prodotto();
	    prod.setNome(dto.getNome());
	    prod.setDisponibilita(dto.getDisponibilita());
	    prod.setPrezzo(dto.getPrezzo());
	    prod.setNomeImmagine(dto.getNomeImmagine());
	    prod.setCategoria(categoria);
	    return prod;
	}


}
