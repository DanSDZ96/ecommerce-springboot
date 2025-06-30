package org.schiano.e_commerce.repository;

import org.schiano.e_commerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Controlla se una categoria esiste già
    boolean isPresentByNome(String nome);

    // Trova una categoria partendo dal nome
    Categoria findByNome(String nome);
}
