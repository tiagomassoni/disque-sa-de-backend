package com.ufcg.si1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

    private Long id;

	private String rua;

	private String uf;

	private String cidade;

	public Endereco(String rua, String uf, String cidade) {
		this.rua = rua;
		this.uf = uf;
		this.cidade = cidade;
	}

    @Column(name = "rua", updatable = false)
	public String getRua() {
		return this.rua;
	}

    @Column(name = "uf", updatable = false)
	public String getUf() {
		return this.uf;
	}

    @Column(name = "cidade", updatable = false)
	public String getCidade() {
		return this.cidade;
	}

    public void setRua(String rua) {
		this.rua = rua;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id", updatable = false)    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
