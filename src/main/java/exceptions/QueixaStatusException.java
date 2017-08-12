package exceptions;

import javax.print.DocFlavor;

/**
 * Created by sampaio on 11/08/17.
 */

public class QueixaStatusException extends QueixaException{

    private static final String MESSAGE = "Status inválido para o estado atual da queixa.";

    public QueixaStatusException(String error){
        super(error);
    }

    public QueixaStatusException(){
        super(MESSAGE);
    }



}
