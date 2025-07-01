package org.schiano.e_commerce.dto;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;

	//usiamo questa classe per gestire l'errore, in questo modo possiamo
	//condensare le info utili in poche righe

@Data
public class ErrorMessageDTO {
	private LocalDateTime timeStamp = LocalDateTime.now();
	private int statusCode;
	private String statusString;
	private String targetURL;
	private Map<String, String> fieldErrors;

}
