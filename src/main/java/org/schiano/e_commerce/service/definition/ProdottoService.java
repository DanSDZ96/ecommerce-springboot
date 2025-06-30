package org.schiano.e_commerce.service.definition;

import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.model.Prodotto;

public interface ProdottoService extends GeneralService<Prodotto> {
	
	void insert(NuovoProdottoDTO prodotto) throws Exception;

}
