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

    int size();

	Iterator<Queixa> getIterator();

	void abrirQueixa(Queixa queixa);

	/**
	 * Método que calcula a porcentagem a eficiência das queixas;
     *      - Calcula-se a porção de queixas abertas em relação ao total;
	 * @return um double representado a proporção entre queixas abertas e fechadas
	 */
    Double getQueixaEficiencia();


//	boolean isUserExi
// st(Queixa user);
	
}
