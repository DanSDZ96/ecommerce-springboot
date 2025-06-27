package org.schiano.e_commerce.dto;

import java.util.List;

public class UtenteDTO {
	private long id;
	private String username;
	private String email;
	private List<OrdineDTO> ordineDTO;
	private List<RecensioneDTO> recensioniDTO;
	private List<ProdottoDTO> carrelloDTO;

}
