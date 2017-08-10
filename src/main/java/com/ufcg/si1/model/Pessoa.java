package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufcg.si1.model.queixa.Queixa;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pessoa_table")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private String rua;

	@Column
	private String uf;

	@Column
	private String cidade;

	@Column
	private String bairro;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Queixa> queixa;

	//JPA
	public Pessoa(){

	}


	public Pessoa(String nome, String email, String rua, String uf,
			String cidade) {
		this.nome = nome;
		this.email = email;
		this.rua = rua;
		this.uf = uf;
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Queixa> getQueixa() {
		return queixa;
	}

	public void setQueixa(Set<Queixa> queixa) {
		this.queixa = queixa;
	}


	public String getRua() {
		return rua;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
