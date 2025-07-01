package org.schiano.e_commerce.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UtenteDTO {
	private long id;
	private String username;
	private String email;
	private List<OrdineDTO> ordineDTO;
	private List<RecensioneDTO> recensioniDTO;
	private List<ProdottoDTO> carrelloDTO;

}
