package com.ufcg.si1.service.factory;

import com.ufcg.si1.model.Pessoa;
import com.ufcg.si1.model.form.QueixaForm;
import com.ufcg.si1.model.queixa.Queixa;

/**
 * Created by sampaio on 15/08/17.
 */
public class QueixaFactory {

    public static Queixa createQueixa (QueixaForm queixaForm){

        Pessoa solicitante = new Pessoa(queixaForm.getNome(), queixaForm.getEmail(), queixaForm.getRua(),
                queixaForm.getUf(), queixaForm.getCidade());


        Queixa queixa = new Queixa(queixaForm.getDescricao(), solicitante);

        return queixa;

    }

}
