package org.schiano.e_commerce.error.handlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.schiano.e_commerce.error.exceptions.EmailNonValidaException;
import org.schiano.e_commerce.error.exceptions.NessunRisultatoException;
import org.schiano.e_commerce.error.exceptions.ProdottoNonTrovatoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class MyExceptionhandler {

    @ExceptionHandler(NessunRisultatoException.class)
    public ResponseEntity<Object> handleNessunRisultatoException(NessunRisultatoException ex, WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", LocalDateTime.now());
        responseBody.put("status", HttpStatus.NOT_FOUND.value());
        responseBody.put("error", "Nessun risultato trovato");
        responseBody.put("message", ex.getMessage());
        responseBody.put("path", request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

    
    @ExceptionHandler(EmailNonValidaException.class)
    public ResponseEntity<Object> handleEmailNonValida(EmailNonValidaException ex, WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", LocalDateTime.now());
        responseBody.put("status", HttpStatus.BAD_REQUEST.value());
        responseBody.put("error", "Email non valida");
        responseBody.put("message", ex.getMessage());
        responseBody.put("path", request.getDescription(false));
        return ResponseEntity.badRequest().body(responseBody);
    }

    @ExceptionHandler(ProdottoNonTrovatoException.class)
    public ResponseEntity<Object> handleProdottoNonTrovato(ProdottoNonTrovatoException ex, WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", LocalDateTime.now());
        responseBody.put("status", HttpStatus.NOT_FOUND.value());
        responseBody.put("error", "Prodotto non trovato");
        responseBody.put("message", ex.getMessage());
        responseBody.put("path", request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }
    

    // Gestione generica
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        Map<String, Object> rBody = new HashMap<>();
        rBody.put("timestamp", LocalDateTime.now());
        rBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        rBody.put("error", "Errore interno");
        rBody.put("message", ex.getMessage());
        rBody.put("path", request.getDescription(false));
        return ResponseEntity.internalServerError().body(rBody);
    }
}
