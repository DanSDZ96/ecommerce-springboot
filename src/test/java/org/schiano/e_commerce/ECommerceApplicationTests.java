package org.schiano.e_commerce;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.schiano.e_commerce.ECommerceApplication;
import org.schiano.e_commerce.dto.NuovoProdottoDTO;
import org.schiano.e_commerce.dto.RimuoviProdottoDTO;

@SpringBootTest
@ContextConfiguration(classes = ECommerceApplication.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureMockMvc
class ECommerceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @Order(1)
    @WithMockUser(username = "FintoUtente", authorities = "ROLE_ADMIN" )
    public void testInserisciProdotto() throws Exception {
        NuovoProdottoDTO prodotto = new NuovoProdottoDTO();
        prodotto.setNome("Prodotto Test");
        prodotto.setDisponibilita(10);
        prodotto.setPrezzo(19.99);
        prodotto.setNomeImmagine("immagine.jpg");
        prodotto.setCategoria_id(1L);  // Assumi categoria 1 esistente

        String str = objectMapper.writeValueAsString(prodotto);

        RequestBuilder request = post("/admin/inserisci")
            .contentType(MediaType.APPLICATION_JSON)
            .content(str);

        mockMvc.perform(request)
            .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    @WithMockUser(username = "FintoUtente", authorities = "ROLE_ADMIN" )
    public void testInserisciProdottoDatiNonValidi() throws Exception {
        NuovoProdottoDTO prodotto = new NuovoProdottoDTO();
        prodotto.setNome(""); 				// Nome vuoto, non valido
        prodotto.setDisponibilita(-1); 		// Valore non valido
        prodotto.setPrezzo(-10.0); 			// Prezzo negativo non valido
        prodotto.setNomeImmagine(""); 		// Nome immagine vuoto
        prodotto.setCategoria_id(null); 	// Categoria non specificata

        String str = objectMapper.writeValueAsString(prodotto);

        RequestBuilder request = post("/admin/inserisci")
            .contentType(MediaType.APPLICATION_JSON)
            .content(str);
        
        ResultMatcher risultato = MockMvcResultMatchers.status().isInternalServerError();

        mockMvc.perform(request)
            .andExpect(risultato);
    }

    
    @Test
    @Order(3)
    @WithUserDetails("daniel")
    public void testVisualizzaProdotti() throws Exception {
        RequestBuilder request = get("/utente/visualizza")
            .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    @Order(4)
    @WithUserDetails("daniel")
    public void testRimuoviProdotto() throws Exception {
        RimuoviProdottoDTO rimuovi = new RimuoviProdottoDTO();
        rimuovi.setId(1L);  // Id del prodotto da rimuovere (deve esistere)

        String json = objectMapper.writeValueAsString(rimuovi);

        RequestBuilder request = delete("/admin/rimuovi")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json);

        mockMvc.perform(request)
            .andExpect(status().isOk());
    }
}
