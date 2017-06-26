package com.ufcg.si1.model;


public class Hospital extends UnidadeSaude{
    private int numeroMedicos;

    private float numeroPacientesDia;

    public Hospital(String descricao, int medicos, float num) {
        super(descricao);
        this.numeroMedicos = medicos;
        this.numeroPacientesDia = num;
    }

    public Hospital(){
        super();
    }

    public int medicos() {
        return this.numeroMedicos;
    }


    public int getNumeroMedicos() {
        return numeroMedicos;
    }

    public void setNumeroMedicos(int numeroMedicos) {
        this.numeroMedicos = numeroMedicos;
    }

    public float getNumeroPacientesDia() {
        return numeroPacientesDia;
    }

    public void setNumeroPacientesDia(float numeroPacientesDia) {
        this.numeroPacientesDia = numeroPacientesDia;
    }
}
