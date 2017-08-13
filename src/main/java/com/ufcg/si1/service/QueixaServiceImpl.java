package com.ufcg.si1.service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.stateQueixa.STATUS_QUEIXA;
import com.ufcg.si1.repositories.QueixaRepository;
import exceptions.ObjetoInvalidoException;
import exceptions.QueixaException;
import exceptions.QueixaInexistenteException;
import exceptions.QueixaRegistradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {


    @Autowired
    private QueixaRepository queixaRepository;



    @Override
    public Collection<Queixa> findAllQueixas() {
        return this.queixaRepository.findAll();
    }

    @Override
    public Queixa findById(Long id) {
        return this.queixaRepository.findById(id);

    }

    @Override
    public Queixa updateQueixa(Queixa queixa) throws QueixaInexistenteException {

        if(existeQueixa(queixa.getId())){
            return saveQueixaExistente(queixa);
        }else{
            throw new QueixaInexistenteException();
        }


    }


    @Override
    public Queixa deleteQueixaById(Long id) throws QueixaInexistenteException {

        if(existeQueixa(id)){
            Queixa deletada = queixaRepository.findById(id);
            queixaRepository.delete(id);
            return deletada;
        }else {
            throw new QueixaInexistenteException();
        }

    }


    @Override
    public int size() {
       return queixaRepository.findAll().size();
    }


    @Override
    public Queixa abrirQueixa(Queixa queixa) throws QueixaRegistradaException {

        if( ehQueixaUnica(queixa)){

            return queixaRepository.save(queixa);
        }else{
            throw new QueixaRegistradaException();
        }


    }

    @Override
    public Double getQueixaAbertaPorcentagem() {

        int count = 0;
        Iterator iterator = queixaRepository.findAll().iterator();
        while(iterator.hasNext()){
            Queixa currentQueixa = (Queixa) iterator.next();
            if(ehQueixaAberta(currentQueixa))
                count++;
        }

        double result = (double) count/size();
        return new Double(result);
    }

    @Override
    public boolean isAberta(Long id) {
        Queixa currentQueixa = queixaRepository.findById(id);
        return ehQueixaAberta(currentQueixa);
    }

    @Override
    public Queixa fecharQueixa(Long id, String comentario) throws QueixaException {

        Queixa currentQueixa = this.queixaRepository.findById(id);
        if(currentQueixa != null){
            currentQueixa.fechar(comentario);
            return saveQueixaExistente(currentQueixa);
        }else{
            throw new QueixaInexistenteException();
        }

    }

    /**
     * Salva uma queixa existente no repositório
     * @param queixa
     * @return queixa salva
     */
    private Queixa saveQueixaExistente(Queixa queixa){

        return queixaRepository.save(queixa);
    }

    /*
    verifica se a queixa existe no repositorio
     */
    private boolean existeQueixa(Long id){
        return queixaRepository.exists(id);
    }

    /*
    Verifica se a queixa é única
     */
    private boolean ehQueixaUnica(Queixa queixa){

        return queixaRepository.findByIdAndDescricao(queixa.getId(), queixa.getDescricao()) == null;

    }

    /*
    Verifica se a queixa está aberta
     */
    private boolean ehQueixaAberta(Queixa queixa){
        return queixa.getSituacao().status() == STATUS_QUEIXA.ABERTA;
    }


}
