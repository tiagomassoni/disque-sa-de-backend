package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.RepositorioException;

import java.util.List;


public interface UnidadeSaudeService {
    Object procura(int codigo) throws RepositorioException,
            ObjetoInexistenteException;

    List<Object> getAll();

    void insere(Object us)throws RepositorioException,
            ObjetoJaExistenteException;

    boolean existe(int codigo);

    Object findById(long id);

    Object findByBairro(String bairro);
}
