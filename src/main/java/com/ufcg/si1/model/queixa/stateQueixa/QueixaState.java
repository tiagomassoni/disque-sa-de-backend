package com.ufcg.si1.model.queixa.stateQueixa;

import com.ufcg.si1.model.queixa.Queixa;
import exceptions.QueixaStatusException;

import javax.persistence.*;

/**
 * Esta classe abstrata faz parte da implementação do padrão state para o status da queixa
 *
 * Created by sampaio on 11/08/17.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class QueixaState {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(updatable = false, nullable = false)
    protected Long id;

    /**
     * Abre uma queixa retornando um novo estado;
     * @return
     */
   public abstract QueixaState abrir() throws QueixaStatusException;

    /**
     * Fecha uma queixa retornado um novo estado;
     * @return
     */
    public abstract QueixaState fechar() throws QueixaStatusException;

    public abstract STATUS_QUEIXA status();

}
