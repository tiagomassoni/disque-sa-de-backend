package com.ufcg.si1.service;

import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.List;

import com.ufcg.si1.model.UnidadeSaude;


public interface UnidadeSaudeService {
  

    List<UnidadeSaude> getAll();

    void insere(UnidadeSaude unidade)throws Rep,
            ObjetoJaExistenteException;

    boolean existe(int codigo);

    UnidadeSaude findById(long id);

    Object findByBairro(String bairro);
    
    Double mediaMedica(Object unidade);
}
