package org.schiano.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecensioneDTO {
	private long id;
	private int punteggio;	
	private String descrizione;

}
