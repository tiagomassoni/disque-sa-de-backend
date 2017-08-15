package com.ufcg.si1.controller.prefeitura;

import com.ufcg.si1.model.form.QueixaForm;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.factory.QueixaFactory;
import exceptions.QueixaException;
import exceptions.QueixaRegistradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by sampaio on 15/08/17.
 */
@Controller
public class PrefeituraController implements Prefeitura {

    @Autowired
    private QueixaService queixaService;

    @Override
    public Queixa abrirQueixa(QueixaForm queixaForm) throws QueixaException {

       Queixa queixa = QueixaFactory.createQueixa(queixaForm);

       return queixaService.abrirQueixa(queixa);


    }

}
