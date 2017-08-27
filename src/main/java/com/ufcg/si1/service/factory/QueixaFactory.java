package com.ufcg.si1.service.factory;

import com.ufcg.si1.model.Pessoa;
import com.ufcg.si1.model.form.QueixaForm;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.QueixaAnimal;
import com.ufcg.si1.model.queixa.TIPO_QUEIXA;

/**
 * Created by sampaio on 15/08/17.
 */
public class QueixaFactory {

    public static Queixa createQueixa (QueixaForm queixaForm){

        Queixa queixa;
        Pessoa solicitante = new Pessoa(queixaForm.getNome(), queixaForm.getEmail(), queixaForm.getRua(),
                queixaForm.getUf(), queixaForm.getCidade());

        if(queixaForm.getTipoDeQueixa().equals(TIPO_QUEIXA.ANIMAL.toString())){

            queixa = new QueixaAnimal(queixaForm.getDescricao(), queixaForm.getComentario(),
                    solicitante, TIPO_QUEIXA.ANIMAL, queixaForm.getLocal(), queixaForm.getTipoAnimal());

        }else{

            queixa = new Queixa(queixaForm.getDescricao(), queixaForm.getComentario(), solicitante, TIPO_QUEIXA.ALIMENTAR);

        }

        return queixa;

    }

}
