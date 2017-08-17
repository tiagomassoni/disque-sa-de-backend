package com.ufcg.si1.model.queixa.stateQueixa;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.exceptions.QueixaStatusException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 STATE)
 * Esta classe representa um dos estados da queixa.
 * Created by sampaio on 11/08/17.
 */
@Entity
public class QueixaStatusFechada extends QueixaState {


    @Override
    public QueixaState abrir() throws QueixaStatusException {
        return new QueixaStatusAberta();
    }

    @Override
    public QueixaState fechar() throws QueixaStatusException {
        throw new QueixaStatusException("A queixa já está fechada.");
    }

    @Override
    public STATUS_QUEIXA status() {
        return STATUS_QUEIXA.FECHADA;
    }

}
