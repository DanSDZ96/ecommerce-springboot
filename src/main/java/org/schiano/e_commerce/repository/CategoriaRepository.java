package org.schiano.e_commerce.repository;

import org.schiano.e_commerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // ✅ Controlla se esiste già una categoria con un certo nome
    boolean existsByNome(String nome);

    // (Opzionale) Trova una categoria specifica per nome
    Categoria findByNome(String nome);
}
