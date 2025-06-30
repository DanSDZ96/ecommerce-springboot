package org.schiano.e_commerce.dto;

// import jakarta.validation.constraints.*; // ← Scommenta quando attivi la validazione

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NuovoProdottoDTO {

    // @NotBlank
    private String nome;

    // @NotNull
    // @Min(0)
    private Integer disponibilita;

    // @NotNull
    // @DecimalMin(value = "0.0", inclusive = true)
    private Double prezzo;

    // @NotBlank
    private String nomeImmagine;

    // @NotNull
    private Integer categoriaId;
}
