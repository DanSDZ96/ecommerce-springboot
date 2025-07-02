package org.schiano.e_commerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RimuoviProdottoDTO {

    @NotNull(message = "L'ID del prodotto da rimuovere è obbligatorio")
    private Long id;
}
