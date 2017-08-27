package com.ufcg.si1.model.queixa;

import com.ufcg.si1.model.Pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by sampaio on 27/08/17.
 */
@Entity
public class QueixaAnimal extends Queixa {


    public QueixaAnimal(){
        super();
    }

    public QueixaAnimal(String descricao, String comentario, Pessoa socilitante, TIPO_QUEIXA tipo, String local, String tipoAnimal) {
        super(descricao, comentario, socilitante, tipo);
        this.local = local;
        this.tipoAnimal = tipoAnimal;
    }

    @Column
    private String local;

    @Column
    private String tipoAnimal;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

}
