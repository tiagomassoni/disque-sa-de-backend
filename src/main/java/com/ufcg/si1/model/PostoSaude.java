package com.ufcg.si1.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PostoSaude extends UnidadeSaude{
	
	private int atendentes;
    
    private float taxaDiariaAtendimentos;

    public PostoSaude(int at, int taxa) {
        this.atendentes = at;
        this.taxaDiariaAtendimentos = taxa;
    }

    public PostoSaude(){
        super();
    }

    @Column(name ="atendentes", updatable = false)
    public int getAtendentes() {
        return atendentes;
    }

    public void setAtendentes(int atendentes) {
        this.atendentes = atendentes;
    }

    @Column(name="taxaDiariaAtendimentos", updatable = false)
    public float getTaxaDiariaAtendimentos() {
        return taxaDiariaAtendimentos;
    }

    public void setTaxaDiariaAtendimentos(float taxaDiariaAtendimentos) {
        this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
    }
}
