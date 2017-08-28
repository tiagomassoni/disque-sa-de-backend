package com.ufcg.si1.model.queixa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.model.HospitalAdapter;
import com.ufcg.si1.model.Pessoa;
import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.queixa.stateQueixa.QueixaState;
import com.ufcg.si1.model.queixa.stateQueixa.QueixaStatusAberta;
import com.ufcg.si1.model.queixa.stateQueixa.STATUS_QUEIXA;
import com.ufcg.si1.exceptions.QueixaException;

import javax.persistence.*;

import java.util.Calendar;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoDeQueixa")
@JsonSubTypes({
		@JsonSubTypes.Type(value = QueixaAnimal.class, name = "ANIMAL"),
		@JsonSubTypes.Type(value = QueixaAlimentar.class, name = "ALIMENTAR")

})
public class Queixa {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false, unique = true)
	protected Long id;

	@Column(name = "descricao")
	private String descricao;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(nullable = false)
	private Pessoa solicitante;

	@OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    @JsonIgnore
	public QueixaState situacao;

	@Column
	private String comentario;


    @Column
    @Enumerated(EnumType.STRING)
	private STATUS_QUEIXA status;

	@Column
    @Temporal(TemporalType.DATE)
    private Calendar publicacaoData;


	@Column
	@Enumerated(EnumType.STRING)
	private TIPO_QUEIXA tipoQueixa;

    //JPA
    public Queixa(){}

    public Queixa(String descricao, String comentario,
				  Pessoa socilitante, TIPO_QUEIXA tipo) {

		this.descricao = descricao;
		this.situacao = new QueixaStatusAberta();
		this.comentario = comentario;
		this.solicitante = socilitante;
		this.status = this.situacao.status();
		this.comentario = "";
		this.tipoQueixa = tipo;
		this.publicacaoData = Calendar.getInstance();

	}

	//FIXME: eu não sei deveria ter esse construtor aqui, acho mais elegante e pode ser usado
	//em alguma parte do código
	public Queixa(String descricao, Pessoa solicitante) {

		//FIXME: esse id passado por parametro tá muito feio

		this.descricao = descricao;
		this.solicitante = solicitante;
		this.situacao = new QueixaStatusAberta();
		this.comentario = "";
		this.publicacaoData = Calendar.getInstance();
		this.status = this.situacao.status();
	}


	public void abrir() throws QueixaException {

		this.situacao = this.situacao.abrir();
		this.status = this.situacao.status();
	}

	public void fechar(String coment) throws QueixaException {

	    this.comentario = coment;
	    this.situacao = this.situacao.fechar();
        this.status = this.situacao.status();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setSituacao(QueixaState status){
	    this.situacao = status;
    }

    public QueixaState getSituacao(){
	    return this.situacao;
    }

	public Pessoa getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}


	//TODO: REFATORAR EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Queixa queixa = (Queixa) o;

        if (descricao != null ? !descricao.equals(queixa.descricao) : queixa.descricao != null) return false;
        return solicitante != null ? solicitante.equals(queixa.solicitante) : queixa.solicitante == null;
    }

    @Override
    public int hashCode() {
        int result = descricao != null ? descricao.hashCode() : 0;
        result = 31 * result + (solicitante != null ? solicitante.hashCode() : 0);
        return result;
    }



    public STATUS_QUEIXA getStatus() {
        return status;
    }

    public void setStatus(STATUS_QUEIXA status) {
        this.status = status;
    }

    public Calendar getPublicacaoData() {
        return publicacaoData;
    }

    public void setPublicacaoData(Calendar publicacaoData) {
        this.publicacaoData = publicacaoData;
    }

	public TIPO_QUEIXA getTipoQueixa() {
		return tipoQueixa;
	}

	public void setTipoQueixa(TIPO_QUEIXA tipoQueixa) {
		this.tipoQueixa = tipoQueixa;
	}

}