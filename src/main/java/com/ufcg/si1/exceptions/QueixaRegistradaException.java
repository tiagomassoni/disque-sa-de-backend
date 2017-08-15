package com.ufcg.si1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sampaio on 09/08/17.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class QueixaRegistradaException extends QueixaException {

    private static final String MESSAGE = "Esta queixa já foi registrada.";

    public QueixaRegistradaException(String error){
        super(error);
    }

    public QueixaRegistradaException(){
        super(MESSAGE);
    }
}
