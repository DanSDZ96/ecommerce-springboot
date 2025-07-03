package org.schiano.e_commerce.service.impl;

import java.util.List;

import org.schiano.e_commerce.dto.InsertUtenteDTO;
import org.schiano.e_commerce.dto.UtenteDTO;
import org.schiano.e_commerce.mapper.UtenteMapper;
import org.schiano.e_commerce.model.Ruolo;
import org.schiano.e_commerce.model.Utente;
import org.schiano.e_commerce.repository.UtenteRepository;
import org.schiano.e_commerce.service.definition.UtenteService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtenteServiceJPA implements UtenteService {

    private final UtenteRepository utenteRepository;
    private final UtenteMapper utenteMapper;
    private final PasswordEncoder passwordEncoder;

    public UtenteDTO save(InsertUtenteDTO utenteDTO) {
        Utente temp = utenteMapper.fromInsertUtenteDTO(utenteDTO);
        temp.setUsername(utenteDTO.getUsername());
        temp.setRuolo(Ruolo.UTENTE);
        temp.setPassword(passwordEncoder.encode(utenteDTO.getPassword()));
        temp.setEmail(utenteDTO.getEmail());
        temp = utenteRepository.save(temp);
        return utenteMapper.toUtenteDTO(temp);
    }

	@Override
	public void create(Utente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
