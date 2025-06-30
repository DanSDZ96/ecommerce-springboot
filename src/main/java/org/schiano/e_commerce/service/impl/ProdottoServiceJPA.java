package org.schiano.e_commerce.service.impl;

import java.util.List;
import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.model.Prodotto;
import org.schiano.e_commerce.service.definition.ProdottoService;
import org.springframework.stereotype.Service;


@Service
public class ProdottoServiceJPA implements ProdottoService {


	
	
	
	
	
	
	
	
	
	
	@Override
	public void create(Prodotto entity) {
		// TODO Auto-generated method stub		
	}

	@Override
	public List<Prodotto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prodotto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Prodotto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(NuovoProdottoDTO prodotto) throws Exception {
		Prodotto p = prodotto
		create(prodotto);
		
	}

}
