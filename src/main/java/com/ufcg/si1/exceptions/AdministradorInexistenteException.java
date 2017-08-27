package com.ufcg.si1.exceptions;

import com.ufcg.si1.model.Administrador;

/**
 * Created by sampaio on 17/08/17.
 */
public class AdministradorInexistenteException extends AdministradorException {

    private static final String MESSAGE = "Administrador inexistente.";

    public AdministradorInexistenteException(String error) {
        super(error);
    }

    public AdministradorInexistenteException(){
        super(MESSAGE);
    }
}
