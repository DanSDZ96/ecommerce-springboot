package org.schiano.e_commerce.service.definition;

import java.util.List;

import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.dto.ProdottoDTO;
import org.schiano.e_commerce.model.Categoria;
import org.schiano.e_commerce.model.Prodotto;

public interface ProdottoService extends GeneralService<Prodotto> {
	
	void insert(NuovoProdottoDTO prodotto, Categoria cat); // throws Exception;
	List<ProdottoDTO> getAllDTO();

	

}
