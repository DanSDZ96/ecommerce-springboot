package org.schiano.e_commerce.service.impl;

import java.util.List;

import org.schiano.e_commerce.dto.InserimentoCategoriaDTO;
import org.schiano.e_commerce.mapper.CategoriaMapper;
import org.schiano.e_commerce.model.Categoria;
import org.schiano.e_commerce.repository.CategoriaRepository;
import org.schiano.e_commerce.service.definition.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceJPA implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public void insert(InserimentoCategoriaDTO dto) {
        Categoria categoria = categoriaMapper.fromInsertCategoriaDTO(dto);
        create(categoria);
    }

    @Override
    public void create(Categoria entity) {
        repository.save(entity);
    }

    @Override
    public List<Categoria> getAll() {
        return repository.findAll();
    }

    @Override
    public Categoria getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Categoria entity) {
        if (repository.existsById(entity.getId())) {
            repository.save(entity);
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
