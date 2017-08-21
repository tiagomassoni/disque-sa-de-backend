package com.ufcg.si1.service;

import com.ufcg.si1.exceptions.ObjetoJaExistenteException;
import com.ufcg.si1.exceptions.Rep;

import java.util.Collection;
import java.util.List;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import org.springframework.stereotype.Service;

@Service
public interface UnidadeSaudeService {

	/**
	 * 
	 * @return todas as unidades
	 */
	Collection<UnidadeSaude> getAll();

	/**
	 * Insere uma unidade no repositorio
	 * 
	 * @param unidade
	 * @throws Rep
	 * @throws ObjetoJaExistenteException
	 */
	void insere(UnidadeSaude unidade) throws Rep, ObjetoJaExistenteException;

	/**
	 * 
	 * @param id da Unidade buscada
	 * @return boolean indicando a existencia ou nao de uma unidade
	 */
	boolean existe(Long id);

	/**
	 * 
	 * @param id da Unidade buscada
	 * @return Unidade que possude id especificado
	 * 
	 */
	UnidadeSaude findById(long Id);

	/**
	 * 
	 * @param bairro da Unidade buscada
	 * @return Unidade que pertence ao bairro especificado
	 */
	List<UnidadeSaude> findByBairro(String bairro);

	Double mediaMedica(UnidadeSaude unidade);
	
	List<Especialidade> especialidadesPorUnidade(Long id);
}
