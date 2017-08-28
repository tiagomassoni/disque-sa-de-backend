package com.ufcg.si1.model;


import javax.persistence.Entity;
import javax.persistence.Transient;

import br.edu.ufcg.Hospital;

@Entity
public class HospitalAdapter extends UnidadeSaude{
	
	@Transient
	private Hospital hospital;

	public HospitalAdapter() {
		super();
		this.hospital = new Hospital("", 0, 0); 
	}
	
   
	public int getAtendentes() {
        return this.hospital.getNumeroMedicos();
    }

    public void setAtendentes(int atendentes) {
        this.hospital.setNumeroMedicos(atendentes);
    }

    
    public float getTaxaDiariaAtendimentos() {
        return this.hospital.getNumeroPacientesDia();
    }

    public void setTaxaDiariaAtendimentos(float taxaDiariaAtendimentos) {
        this.hospital.setNumeroPacientesDia(taxaDiariaAtendimentos);;
    }
	
}
