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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (nome != null ? !nome.equals(pessoa.nome) : pessoa.nome != null) return false;
        if (email != null ? !email.equals(pessoa.email) : pessoa.email != null) return false;
        if (rua != null ? !rua.equals(pessoa.rua) : pessoa.rua != null) return false;
        if (uf != null ? !uf.equals(pessoa.uf) : pessoa.uf != null) return false;
        return cidade != null ? cidade.equals(pessoa.cidade) : pessoa.cidade == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        return result;
    }
}
