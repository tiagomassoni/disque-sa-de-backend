package com.ufcg.si1.model.queixa;

import javax.print.DocFlavor;

/**
 * Created by sampaio on 08/08/17.
 */
public enum STATUS_QUEIXA {

    ABERTA("ABERTA"),
    EM_ANDAMENTO("EM_ANDAMENTO"),
    FECHADA("FECHADA");

    private String status;
    private STATUS_QUEIXA(String status){
        this.status = status;
    }
    public String toString(){
        return status;
    }

}
