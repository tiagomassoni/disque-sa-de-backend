package com.ufcg.si1.controller.prefeitura;

import com.ufcg.si1.model.form.QueixaForm;
import com.ufcg.si1.model.queixa.Queixa;
import exceptions.QueixaException;
import exceptions.QueixaRegistradaException;

/**
 * Created by sampaio on 15/08/17.
 */
public interface Prefeitura {

    Queixa abrirQueixa(QueixaForm queixaForm) throws QueixaException;





}
