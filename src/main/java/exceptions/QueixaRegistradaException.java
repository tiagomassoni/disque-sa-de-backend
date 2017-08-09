package exceptions;

/**
 * Created by sampaio on 09/08/17.
 */
public class QueixaRegistradaException extends Exception {

    private static final String MESSAGE = "Esta queixa já foi registrada.";

    public QueixaRegistradaException(String error){
        super(error);
    }

    public QueixaRegistradaException(){
        super(MESSAGE);
    }
}
