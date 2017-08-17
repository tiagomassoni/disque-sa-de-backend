package com.ufcg.si1.repositories;

import com.ufcg.si1.model.Pessoa;
import com.ufcg.si1.model.queixa.Queixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by sampaio on 09/08/17.
 */
@Repository
public interface QueixaRepository extends JpaRepository<Queixa,  Long> {

    Queixa findById(Long id);

    @Transactional
    Queixa findBySolicitanteAndDescricao(Pessoa pessoa, String descricao);

    Queixa findByDescricao(String descricao);


}