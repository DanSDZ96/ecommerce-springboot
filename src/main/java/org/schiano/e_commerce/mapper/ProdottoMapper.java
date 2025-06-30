package org.schiano.e_commerce.mapper;

import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.dto.ProdottoDTO;
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

    public ProdottoDTO toDTO(Prodotto p) {
        ProdottoDTO dto = new ProdottoDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setDisponibilita(p.getDisponibilita());
        dto.setPrezzo(p.getPrezzo());
        dto.setNomeImmagine(p.getNomeImmagine());

        dto.setCategoriaId(p.getCategoria().getId());
        dto.setCategoriaNome(p.getCategoria().getNome());

        return dto;
    }
}
