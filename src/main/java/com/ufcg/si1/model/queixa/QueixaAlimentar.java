package com.ufcg.si1.model.queixa;

import com.ufcg.si1.model.Pessoa;

import javax.persistence.Entity;

/**
 * Created by sampaio on 27/08/17.
 */
@Entity
public class QueixaAlimentar extends Queixa {

    public QueixaAlimentar(){
        super();
    }

    public QueixaAlimentar(String descricao, String comentario, Pessoa socilitante, TIPO_QUEIXA tipo) {
        super(descricao, comentario, socilitante, tipo);
    }
}
