package com.ufcg.si1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sampaio on 11/08/17.
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class QueixaException extends Exception {

    private static final String MESSAGE = "Erro em Queixa.";

    public QueixaException(String error){
        super (error);
    }

    public QueixaException(){
        super(MESSAGE);
    }
}

