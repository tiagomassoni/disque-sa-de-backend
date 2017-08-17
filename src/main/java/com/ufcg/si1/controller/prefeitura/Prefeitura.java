package com.ufcg.si1.controller.prefeitura;

import com.ufcg.si1.model.form.QueixaForm;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.exceptions.QueixaException;

import java.util.Collection;

/**
 * Created by sampaio on 15/08/17.
 */
public interface Prefeitura {

    //Todos esse métodos abaixo são delegados para queixaService

    Queixa abrirQueixa(QueixaForm queixaForm) throws QueixaException;

    Collection<Queixa> getTodasAsQueixas();

    Queixa consultarQueixa(Long id) throws QueixaException;

    Queixa updateQueixa(Long id, QueixaForm queixa) throws QueixaException;

    Queixa deleteQueixa(Long id) throws QueixaException;

    Queixa fecharQueixa (Long id, String comentario) throws QueixaException;


}
