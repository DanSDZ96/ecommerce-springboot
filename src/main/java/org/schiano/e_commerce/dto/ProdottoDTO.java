package org.schiano.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdottoDTO {

    private Long id;
    private String nome;
    private Integer disponibilita;
    private Double prezzo;
    private String nomeImmagine;
    private Long categoriaId;
    private String categoriaNome; // aggiunto per visualizzazione
}
