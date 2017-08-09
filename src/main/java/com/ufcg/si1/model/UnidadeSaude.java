package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "posto")
})
@Entity
public class UnidadeSaude {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id; 

    @Column(name="endereco", nullable=false)
    private Endereco endereço;

    private List especialidades = new ArrayList();

    private long [] numeroQueixas = new long[1000];
    int contador = 0;

    public void addQueixaProxima(long id) {
        if (this instanceof PostoSaude){
            numeroQueixas[contador++] = id;
        }
    }

    public List<Especialidade> getEspecialidades() {
        return this.especialidades;
    }

    public void adicionarEspecialidade(Especialidade esp) {
        this.especialidades.add(esp);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return endereço.getBairro();
	}


}
