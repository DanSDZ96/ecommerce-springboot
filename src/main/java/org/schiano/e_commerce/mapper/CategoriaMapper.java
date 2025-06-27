package org.schiano.e_commerce.mapper;

import org.schiano.e_commerce.dto.CategoriaDTO;
import org.schiano.e_commerce.dto.InserimentoCategoriaDTO;
import org.schiano.e_commerce.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

	public Categoria fromInsertCategoriaDTO(InserimentoCategoriaDTO dto) {
		Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        return categoria;
    }
	
	
    public CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }
	
	
	

}
