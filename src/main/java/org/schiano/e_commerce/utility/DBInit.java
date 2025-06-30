package org.schiano.e_commerce.utility;

import org.schiano.e_commerce.model.Categoria;
import org.schiano.e_commerce.model.Prodotto;
import org.schiano.e_commerce.repository.CategoriaRepository;
import org.schiano.e_commerce.repository.ProdottoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DBInit implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Autowired
    private ProdottoRepository prodottoRepo;

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

        System.out.println("✔️ Database inizializzato con categorie e prodotti demo.");
    }
}
