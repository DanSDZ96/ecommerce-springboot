package org.schiano.e_commerce.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdineDTO {

    private Long id;
    private LocalDate dataOrdine;
    private Long utenteId; // oppure UtenteDTO se serve info completa dell'utente
    private List<AcquistoDTO> acquisti; // si può usare anche solo List<Long> se vuoi solo gli ID
}
