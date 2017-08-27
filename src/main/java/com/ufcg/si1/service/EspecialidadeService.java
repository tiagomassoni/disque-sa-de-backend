package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.exceptions.ObjetoInexistenteException;
import com.ufcg.si1.exceptions.ObjetoJaExistenteException;
import com.ufcg.si1.exceptions.Rep;

import java.util.List;


public interface EspecialidadeService {

    void insere(Especialidade esp);

	Especialidade findById(long id);
	
	List<Long> unidadesComEspecialidade(String descricao);

}
