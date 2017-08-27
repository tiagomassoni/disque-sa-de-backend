package com.ufcg.si1.model.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by sampaio on 15/08/17.
 */
public class QueixaForm {

    @NotEmpty
    @NotNull
    private String descricao;

    @NotEmpty
    @NotNull
    private String nome;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Email
    private String rua;

    @NotEmpty
    @Email
    private String uf;

    @NotEmpty
    @Email
    private String cidade;

    private String comentario;

    private String local;

    private String tipoAnimal;

    private String tipoDeQueixa;

    public String getTipoDeQueixa() {
        return tipoDeQueixa;
    }

    public void setTipoDeQueixa(String tipoDeQueixa) {
        this.tipoDeQueixa = tipoDeQueixa;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
