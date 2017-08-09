package com.ufcg.si1.model.queixa;

import com.ufcg.si1.model.Pessoa;
import exceptions.ObjetoInvalidoException;

public class Queixa {

	private long id;

	private String descricao;

	private Pessoa solicitante;

	public STATUS_QUEIXA situacao;

	private String comentario;


	public Queixa(long id, String descricao, int situacao, String comentario,
				  Pessoa socilitante) {
		this.id = id;
		this.descricao = descricao;
		this.situacao = verificaQueixa(situacao);
		this.comentario = comentario;
		this.solicitante = socilitante;
	}

	//FIXME: eu não sei deveria ter esse construtor aqui, acho mais elegante e pode ser usado
	//em alguma parte do código
	public Queixa(long id, String descricao, Pessoa solicitante) {

		//FIXME: esse id passado por parametro tá muito feio

		this.id = id;
		this.descricao = descricao;
		this.solicitante = solicitante;
	}
	
	public void abrir() throws ObjetoInvalidoException {


		if (this.situacao != STATUS_QUEIXA.ABERTA)
			this.situacao = STATUS_QUEIXA.ABERTA;
		else
			throw new ObjetoInvalidoException("Status inválido");
	}

	public void fechar(String coment) throws ObjetoInvalidoException {
		if (this.situacao != STATUS_QUEIXA.FECHADA) {
			this.situacao = STATUS_QUEIXA.FECHADA;
			this.comentario = coment;
		} else
			throw new ObjetoInvalidoException("Status inválido");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public STATUS_QUEIXA getSituacao() {
		return situacao;
	}

	public void setSituacao(STATUS_QUEIXA status){
		this.situacao = status;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pessoa getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queixa other = (Queixa) obj;
		if (id != other.id)
			return false;
		return true;
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

}