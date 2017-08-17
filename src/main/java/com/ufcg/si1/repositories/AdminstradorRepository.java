package com.ufcg.si1.repositories;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.model.UnidadeSaude;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sampaio on 17/08/17.
 */
public interface AdminstradorRepository extends JpaRepository<Administrador,  Long> {


    /**
     * Retorna uma administrador específico dado o email e a senha
     * @param email - email do administrador
     * @param password - password do administrador
     * @return - Uma instâcia de um Adminstrador ou Null
     */
    Administrador findAdministradorByEmailAndPassword(String email, String password);

    /**
     * Retorna uma administrador específico dado o email
     * @param email - email do administrador
     * @return - Uma instâcia de um Adminstrador ou Null
     */
    Administrador findAdministradorByEmail (String email);

}


