package com.ufcg.si1.service;

import com.ufcg.si1.exceptions.AdministradorException;
import com.ufcg.si1.exceptions.AdministradorInexistenteException;
import com.ufcg.si1.model.Administrador;

/**
 * Created by sampaio on 17/08/17.
 */
public interface AdminstradorService {

    /**
     * Realiza o login verificando se o Adminstrador passado como parâmetro está no sistema
      * @param adm - admin a ser verificado
     * @return - Uma instância válida de um Administrador ou null
     */
    Administrador realizarLogin(Administrador adm) throws AdministradorInexistenteException, AdministradorException;

    /**
     * Adiciona um novo adminstrador ao sistema
     * @param adm - adm a ser adicionado
     * @return  Uma instância válida de um Administrador ou null
     */
    Administrador addNovoAdministrador(Administrador adm) throws AdministradorException;

    /**
     * Atualiza os dados cadastrais de um administrador
     * @param adm adm a ser atualizado
     * @return  Uma instância válida de um Administrador ou null
     */
    Administrador atualizaAdministrador (Administrador adm) throws AdministradorException;



}
