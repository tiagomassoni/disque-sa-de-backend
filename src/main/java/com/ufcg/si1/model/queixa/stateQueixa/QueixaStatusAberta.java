package com.ufcg.si1.model.queixa.stateQueixa;

import com.ufcg.si1.model.queixa.Queixa;
import exceptions.QueixaStatusException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * (STATE)
 * Esta classe representa um dos estados da queixa.
 * Created by sampaio on 11/08/17.
 */
@Entity
public class QueixaStatusAberta extends QueixaState{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public QueixaState abrir() throws QueixaStatusException {
        throw new QueixaStatusException("A queixa já está aberta.");
    }

    @Override
    public QueixaState fechar() {
        return new QueixaStatusFechada();
    }

    @Override
    public STATUS_QUEIXA status() {
        return STATUS_QUEIXA.ABERTA;
    }
}
