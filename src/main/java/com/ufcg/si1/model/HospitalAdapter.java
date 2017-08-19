package com.ufcg.si1.model;


import javax.persistence.Column;
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
	
    @Column(name = "numeroMedicos", updatable = false)
	public int getNumeroMedicos() {
        return this.hospital.getNumeroMedicos();
    }

    public void setNumeroMedicos(int atendentes) {
        this.hospital.setNumeroMedicos(atendentes);
    }

    @Column(name = "numeroPacientesDia", updatable = false)
    public float getNumeroPacientesDia() {
        return this.hospital.getNumeroPacientesDia();
    }

    public void setNumeroPacientesDia(float taxaDiariaAtendimentos) {
        this.hospital.setNumeroPacientesDia(taxaDiariaAtendimentos);;
    }
	
}
