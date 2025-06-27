package org.schiano.e_commerce.service.definition;

import org.schiano.e_commerce.dto.InserimentoCategoriaDTO;
import org.schiano.e_commerce.model.Categoria;

public interface CategoriaService extends GeneralService<Categoria>{

	void insert(InserimentoCategoriaDTO categoria) throws Exception;

	//si possono poi aggiungere ulteriori metodi nell'interfaccia specifici a questa
		//poi andranno tutti implementati (override) nell'implementazione
}
