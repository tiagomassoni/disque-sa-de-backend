package exceptions;

import javax.print.DocFlavor;

/**
 * Created by sampaio on 09/08/17.
 */
public class QueixaInexistenteException extends QueixaException {


    private final static String MESSAGE = "Queixa não encontrada.";

    public QueixaInexistenteException(String erro){
        super(erro);
    }

    public QueixaInexistenteException(){
        super(MESSAGE);
    }


}
