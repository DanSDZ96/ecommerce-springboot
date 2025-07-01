package org.schiano.e_commerce.dto;

import org.schiano.e_commerce.model.Categoria;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// import jakarta.validation.constraints.*; // ← Scommenta quando attivi la validazione

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NuovoProdottoDTO {

    @NotBlank (message = "Il nome non può essere una stringa vuota")
    private String nome;

    @NotNull
    @Min(value = 0, message= "La disponibilità non può essere inferiore a 0")
    @Max(value = 999, message = "La disponibilità non può essere superiore a 999")
    private Integer disponibilita;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "Il prezzo non può essere negativo")
    private Double prezzo;

    @NotBlank (message= "Inserisci il nome della foto" )
    private String nomeImmagine;

    @NotNull(message= "Errore nell'id categoria. Attendere manutenzione")
    private Long categoria_id;
}
