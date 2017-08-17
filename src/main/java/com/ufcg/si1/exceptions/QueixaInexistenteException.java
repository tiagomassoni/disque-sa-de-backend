package com.ufcg.si1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sampaio on 09/08/17.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class QueixaInexistenteException extends QueixaException {


    private final static String MESSAGE = "Queixa não encontrada.";

    public QueixaInexistenteException(String erro){
        super(erro);
    }

    public QueixaInexistenteException(){
        super(MESSAGE);
    }


}
