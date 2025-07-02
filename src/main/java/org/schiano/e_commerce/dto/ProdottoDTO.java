package org.schiano.e_commerce.dto;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdottoDTO {

    private Long id;

    @NotBlank(message = "Il nome del prodotto è obbligatorio")
    private String nome;

    @NotNull(message = "La disponibilità è obbligatoria")
    @Min(value = 0, message = "La disponibilità non può essere negativa")
    private Integer disponibilita;

    @NotNull(message = "Il prezzo è obbligatorio")
    @Positive(message = "Il prezzo deve essere maggiore di zero")
    private Double prezzo;

    @NotBlank(message = "Il nome dell'immagine è obbligatorio")
    private String nomeImmagine;

    @NotNull(message = "L'ID della categoria è obbligatorio")
    private Long categoriaId;

    private String categoriaNome;
}
