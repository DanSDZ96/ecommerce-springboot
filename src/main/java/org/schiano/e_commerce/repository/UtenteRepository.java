package org.schiano.e_commerce.repository;

import org.schiano.e_commerce.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByUsername(String username);

}
