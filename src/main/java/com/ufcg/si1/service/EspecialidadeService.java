package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.RepositorioException;

import java.util.List;


public interface EspecialidadeService {
    Especialidade procura(int codigo) throws RepositorioException,
            ObjetoInexistenteException;

    List getListaEspecialidade()
                    throws RepositorioException, ObjetoInexistenteException;

    int size();

    Especialidade getElemento(int posicao);

    void insere(Especialidade esp)throws RepositorioException,
            ObjetoJaExistenteException;

    boolean existe(int codigo);

    Especialidade findById(long id);
}
