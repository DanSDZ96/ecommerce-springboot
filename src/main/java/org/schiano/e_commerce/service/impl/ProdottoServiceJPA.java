package org.schiano.e_commerce.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.dto.ProdottoDTO;
import org.schiano.e_commerce.mapper.CategoriaMapper;
import org.schiano.e_commerce.mapper.ProdottoMapper;
import org.schiano.e_commerce.model.Categoria;
import org.schiano.e_commerce.model.Prodotto;
import org.schiano.e_commerce.repository.CategoriaRepository;
import org.schiano.e_commerce.repository.ProdottoRepository;
import org.schiano.e_commerce.service.definition.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdottoServiceJPA implements ProdottoService {

	@Autowired
	private ProdottoRepository prodRepo;

	@Autowired
	private ProdottoMapper prodMap;

	@Override
	public void create(Prodotto entity) {
		prodRepo.save(entity);
	}

	@Override
	public List<Prodotto> getAll() {
		return prodRepo.findAll();
	}

	@Override
	public Prodotto getById(Long id) {
		return prodRepo.findById(id).orElse(null);
	}

	@Override
	public void update(Prodotto entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		prodRepo.deleteById(id);
	}

	@Override
	public void insert(NuovoProdottoDTO prodotto, Categoria cat) { // throws Exception {
		Prodotto p = prodMap.fromNuovoProdottoDTO(prodotto, cat);
		create(p);

	}

	@Override
	public List<ProdottoDTO> getAllDTO() {
		List<Prodotto> prodotti = prodRepo.findAll();
		List<ProdottoDTO> listaDTO = new ArrayList<>();

		for (Prodotto p : prodotti) {
			ProdottoDTO dto = prodMap.toDTO(p);
			listaDTO.add(dto);
		}

		return listaDTO;
	}

}
