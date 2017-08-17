package com.ufcg.si1.model.queixa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufcg.si1.model.Pessoa;
import com.ufcg.si1.model.queixa.stateQueixa.QueixaState;
import com.ufcg.si1.model.queixa.stateQueixa.QueixaStatusAberta;
import com.ufcg.si1.model.queixa.stateQueixa.STATUS_QUEIXA;
import com.ufcg.si1.exceptions.QueixaException;

import javax.persistence.*;

import java.util.Calendar;

@Entity
@Table(name = "QUEIXA_TABLE")
public class Queixa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
	private Long id;

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
    @Temporal(TemporalType.DATE)
    private Calendar publicacaoData;


	public Queixa(String descricao, int situacao, String comentario,
				  Pessoa socilitante) {

		this.descricao = descricao;
		this.situacao = new QueixaStatusAberta();
		this.comentario = comentario;
		this.solicitante = socilitante;
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
	}



	public void abrir() throws QueixaException {

		this.situacao.abrir();
	}

	public void fechar(String coment) throws QueixaException {

	    this.comentario = coment;
	    this.situacao.fechar();

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

    private STATUS_QUEIXA verificaQueixa(int situacao){

		STATUS_QUEIXA status;
		if(situacao == 1){
			status = STATUS_QUEIXA.ABERTA;
		}else if(situacao == 2){
			status = STATUS_QUEIXA.EM_ANDAMENTO;
		}else{
			status = STATUS_QUEIXA.FECHADA;
		}
		return status;

	}

	//JPA
    public Queixa(){}

    public Calendar getPublicacaoData() {
        return publicacaoData;
    }

    public void setPublicacaoData(Calendar publicacaoData) {
        this.publicacaoData = publicacaoData;
    }



}