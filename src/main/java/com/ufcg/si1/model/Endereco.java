package com.ufcg.si1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco {

    @Id
    @Column
    private Long id;

	private String rua;

	private String uf;

	private String cidade;
	
	private String bairro;

	@OneToOne
    private UnidadeSaude unidade;

	//jpa
	public Endereco(){

	}

	public Endereco(String rua, String uf, String cidade) {
		this.rua = rua;
		this.uf = uf;
		this.cidade = cidade;
	}

	public String getRua() {
		return this.rua;
	}

	public String getUf() {
		return this.uf;
	}

	public String getCidade() {
		return this.cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UnidadeSaude getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeSaude unidade) {
        this.unidade = unidade;
    }
}
