package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.exceptions.ObjetoInexistenteException;
import com.ufcg.si1.exceptions.ObjetoJaExistenteException;
import com.ufcg.si1.exceptions.Rep;

import java.util.List;


public interface EspecialidadeService {
	
    Especialidade procura(int codigo) throws Rep,
            ObjetoInexistenteException;

    List<Especialidade> getListaEspecialidade()
                    throws Rep, ObjetoInexistenteException;

    void insere(Especialidade esp)throws Rep,
            ObjetoJaExistenteException, Exception;

    boolean existe(int codigo);

	Especialidade findById(long id);

}
