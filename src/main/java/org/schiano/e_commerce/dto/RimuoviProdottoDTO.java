package org.schiano.e_commerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Rimuove il prodotto corrispondente all'ID fornito")
public class RimuoviProdottoDTO {

    @NotNull(message = "L'ID del prodotto da rimuovere è obbligatorio")
    @Schema(description = "ID del prodotto da eliminare")
    private Long id;
}
