package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.RepositorioException;

import java.util.List;


public interface UnidadeSaudeService {
    UnidadeSaude procura(int codigo) throws RepositorioException,
            ObjetoInexistenteException;

    List<UnidadeSaude> getAll();

    void insere(UnidadeSaude us)throws RepositorioException,
            ObjetoJaExistenteException;

    boolean existe(int codigo);

    UnidadeSaude findById(long id);

    UnidadeSaude findByBairro(String bairro);
}
