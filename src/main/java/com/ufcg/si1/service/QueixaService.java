package com.ufcg.si1.service;


import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.Queixa;

public interface QueixaService {

	List<Queixa> findAllQueixas();


    void saveQueixa(Queixa queixa);


	Queixa findById(long id);

	void updateQueixa(Queixa user);


	void deleteQueixaById(long id);

    /**
     * Verifica a quantidade de queixas no sistema
     * @return - quantidade de queixas
     */
    int size();

	Iterator<Queixa> getIterator();

	void abrirQueixa(Queixa queixa);

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
     * Modifica o status de uma determinada queixa para o códido da situação atual.
     * @param id - id da queixa
     * @param situacao - nova situação
     */
    void modificaStatusDaQueixa(Long id, int situacao);

    /**
     * Fecha uma determinada queixa passada por id e adiciona o comentário do administrador
     * @param id - id da queixa
     * @param comentario - comentário sobre o desenrolar do processo da queixa
     */
    void fecharQueixa(Long id, String comentario);


//	boolean isUserExi
// st(Queixa user);
	
}
