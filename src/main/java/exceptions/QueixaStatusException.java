package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.print.DocFlavor;

/**
 * Created by sampaio on 11/08/17.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class QueixaStatusException extends QueixaException{

    private static final String MESSAGE = "Status inválido para o estado atual da queixa.";

    public QueixaStatusException(String error){
        super(error);
    }

    public QueixaStatusException(){
        super(MESSAGE);
    }



}
