package com.ufcg.si1.model;


import javax.persistence.*;

@Entity
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="codigo", updatable=false)
    private int codigo;

    @Column(name="descricao", updatable=false)
    private String descricao;
    
    @Column(name="idUs", updatable=false)
    private Long idUs;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUs() {
		return idUs;
	}

	public void setIdUs(Long idUs) {
		this.idUs = idUs;
	}

	public Especialidade(int codigo, String descricao) {
        this.codigo = codigo;
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

}
