package org.schiano.e_commerce.utility;

import java.util.List;

import org.schiano.e_commerce.model.Categoria;
import org.schiano.e_commerce.model.Prodotto;
import org.schiano.e_commerce.model.Ruolo;
import org.schiano.e_commerce.model.Utente;
import org.schiano.e_commerce.repository.CategoriaRepository;
import org.schiano.e_commerce.repository.ProdottoRepository;
import org.schiano.e_commerce.repository.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DBInit implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Autowired
    private ProdottoRepository prodottoRepo;

    @Autowired
    private UtenteRepository utenteRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @Override
    public void run(String... args) throws Exception {
    	
    	

        // Creazione categorie
        Categoria cat1 = new Categoria();
        cat1.setNome("Elettronica");

        Categoria cat2 = new Categoria();
        cat2.setNome("Libri");

        categoriaRepo.save(cat1);
        categoriaRepo.save(cat2);

        // Creazione prodotti
        Prodotto p1 = new Prodotto();
        p1.setNome("Auricolari Bluetooth");
        p1.setDisponibilita(25);
        p1.setPrezzo(39.99);
        p1.setNomeImmagine("auricolari.jpg");
        p1.setCategoria(cat1);

        Prodotto p2 = new Prodotto();
        p2.setNome("Manuale di Java");
        p2.setDisponibilita(12);
        p2.setPrezzo(59.90);
        p2.setNomeImmagine("java.jpg");
        p2.setCategoria(cat2);

        prodottoRepo.save(p1);
        prodottoRepo.save(p2);

        // ✅ UTENTI NORMALI
        Utente user1 = new Utente();
        user1.setUsername("mario");
        user1.setEmail("mario@example.com");
        user1.setPassword(passwordEncoder.encode("1234"));
        user1.setRuolo(Ruolo.UTENTE);

        Utente user2 = new Utente();
        user2.setUsername("luca");
        user2.setEmail("luca@example.com");
        user2.setPassword(passwordEncoder.encode("abcd"));
        user2.setRuolo(Ruolo.UTENTE);

        // ✅ ADMIN
        Utente admin1 = new Utente();
        admin1.setUsername("admin");
        admin1.setEmail("admin@example.com");
        admin1.setPassword(passwordEncoder.encode("admin"));
        admin1.setRuolo(Ruolo.ADMIN);
        
        System.out.println("🧪 Password admin raw: admin");
        System.out.println("🧪 Password admin encoded: " + passwordEncoder.encode("admin"));

        Utente admin2 = new Utente();
        admin2.setUsername("daniel");
        admin2.setEmail("super@example.com");
        admin2.setPassword(passwordEncoder.encode("aurora"));
        admin2.setRuolo(Ruolo.ADMIN);
        
        System.out.println("🧪 Password admin raw: aurora");
        System.out.println("🧪 Password admin encoded: " + passwordEncoder.encode("aurora"));

        utenteRepo.saveAll(List.of(user1, user2, admin1, admin2));

        System.out.println("✔️ DB inizializzato con categorie, prodotti e utenti demo.");
    }
}
