package com.ufcg.si1.repositories;

import com.ufcg.si1.model.queixa.Queixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by sampaio on 09/08/17.
 */
public interface QueixaRepository extends JpaRepository<Queixa,  Long> {

    Queixa findById(Long id);


}
