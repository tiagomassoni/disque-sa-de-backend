package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "posto"),
        @JsonSubTypes.Type(value = HospitalAdapter.class, name = "hospital")
})


@Entity
public class UnidadeSaude {

    private Long id; 
    private String bairro;
    private List<Especialidade> especialidades;

    public void setEspecialidades(List<Especialidade> especialidades){
        this.especialidades = especialidades;
    }
    
    
    @Column(name="especialidades", updatable = false)
    @OneToMany(cascade=CascadeType.ALL)
    public List<Especialidade> getEspecialidades() {
        return this.especialidades;
    }

    public void adicionarEspecialidade(Especialidade esp) {
        this.especialidades.add(esp);
    }

    @Id 
    @GeneratedValue(strategy=GenerationType.TABLE) 
    @Column(name = "id", updatable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Column(name ="bairro", updatable = false)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
