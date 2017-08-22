package com.ufcg.si1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sampaio on 17/08/17.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AdministradorException extends Exception {

    public AdministradorException(String error){
        super(error);
    }

}
