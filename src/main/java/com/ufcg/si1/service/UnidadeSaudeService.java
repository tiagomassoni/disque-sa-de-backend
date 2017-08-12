package com.ufcg.si1.service;

import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

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
	List<UnidadeSaude> getAll();

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
	UnidadeSaude findById(long id);

	/**
	 * 
	 * @param bairro da Unidade buscada
	 * @return Unidade que pertence ao bairro especificado
	 */
	List<UnidadeSaude> findByBairro(String bairro);

	Double mediaMedica(Object unidade);
	
	List<Especialidade> especialidadesPorUnidade(Long id);
}
