package org.schiano.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data					//Genera getter,setter,toString etc..
@NoArgsConstructor
@AllArgsConstructor
public class RegistrazioneDTO {
	private String nome;
	private String cognome;
	private String username;
	private String email;
	
	@ToString.Exclude
	private String password;

}
