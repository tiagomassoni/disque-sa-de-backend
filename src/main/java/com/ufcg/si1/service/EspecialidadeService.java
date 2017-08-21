package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.exceptions.ObjetoInexistenteException;
import com.ufcg.si1.exceptions.ObjetoJaExistenteException;
import com.ufcg.si1.exceptions.Rep;

import java.util.List;


public interface EspecialidadeService {

    List<Especialidade> getListaEspecialidade();

    void insere(Especialidade esp);

    boolean existe(int codigo);

	Especialidade findById(long id);
	
	List<Long> unidadesComEsecialidade(int codigo);

}
