package com.ufcg.si1.model;


import javax.persistence.*;

@Entity
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private UnidadeSaude unidadeSaude;

    @Column
    private int codigo;

    @Column
    private String descricao;

    public Especialidade(String descricao) {
        this.codigo = 0; // gerado no repositorio
        this.descricao = descricao;
    }

    public Especialidade(){

    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int cod) {
        this.codigo = cod;
    }

    public UnidadeSaude getUnidadeSaude() {
        return unidadeSaude;
    }

    public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }
}
