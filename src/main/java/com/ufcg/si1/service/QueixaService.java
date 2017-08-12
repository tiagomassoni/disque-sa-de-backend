package com.ufcg.si1.service;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ufcg.si1.model.queixa.Queixa;
import exceptions.ObjetoInvalidoException;
import exceptions.QueixaException;
import exceptions.QueixaInexistenteException;
import exceptions.QueixaRegistradaException;

public interface QueixaService {

	Collection<Queixa> findAllQueixas();

	Queixa findById(Long id);

	Queixa updateQueixa(Queixa user) throws QueixaInexistenteException;


	Queixa deleteQueixaById(Long id) throws QueixaInexistenteException;

    /**
     * Verifica a quantidade de queixas no sistema
     * @return - quantidade de queixas
     */
    int size();

    /**
     * Abre uma queixa
     * @param queixa
     */
	Queixa abrirQueixa(Queixa queixa) throws QueixaRegistradaException;

	/**
	 * Método que calcula a porcentagem a eficiência das queixas;
     *      - Calcula-se a porção de queixas abertas em relação ao total;
	 * @return um double representado a proporção entre queixas abertas e fechadas
	 */
    Double getQueixaAbertaPorcentagem();

    /**
     * Verifica se uma determinada queixa possui status aberto ou fechado
     * @param id - id da queixa em questão
     * @return - um boolean com o resultado da operação.
     */
	boolean isAberta(Long id);


    /**
     * Fecha uma determinada queixa passada por id e adiciona o comentário do administrador
     * @param id - id da queixa
     * @param comentario - comentário sobre o desenrolar do processo da queixa
     */
    Queixa fecharQueixa(Long id, String comentario) throws ObjetoInvalidoException, QueixaInexistenteException, QueixaException;

	
}
