package com.ufcg.si1.service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.STATUS_QUEIXA;
import exceptions.ObjetoInvalidoException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {


    private final AtomicLong counter = new AtomicLong();

    private Map<Long, Queixa> queixas = new HashMap<>();


    @Override
    public Collection<Queixa> findAllQueixas() {
        return this.queixas.values();
    }

    @Override
    public Queixa findById(long id) {
        return this.queixas.get(id);
        //FIXME: resolver essa exception

    }

    @Override
    public void updateQueixa(Queixa queixa) {
        saveQueixaExistente(queixa);

    }

    @Override
    public void saveQueixa(Queixa queixa) {
        //recendo uma queixa direto da rest
        queixa.setId(counter.incrementAndGet());
        this.queixas.put(queixa.getId(), queixa);

    }

    @Override
    public void deleteQueixaById(long id) {
    	this.queixas.remove(id);
    }

    @Override
    public int size() {
        return this.queixas.size();
    }


    @Override
    public void abrirQueixa(Queixa queixa) {
        queixa.setId(counter.incrementAndGet());
        this.queixas.put(queixa.getId(), queixa);
    }

    @Override
    public Double getQueixaAbertaPorcentagem() {

        int count = 0;
        for(Long currentId : this.queixas.keySet()){

            Queixa currentQueixa = this.queixas.get(currentId);
            if(currentQueixa.getSituacao() == STATUS_QUEIXA.ABERTA)
                count++;

        }
        double result = (double) count/size();
        return new Double(result);
    }

    @Override
    public boolean isAberta(Long id) {
        Queixa currentQueixa = this.queixas.get(id);
        return (currentQueixa.getSituacao() == STATUS_QUEIXA.ABERTA);
    }

    @Override
    public void modificaStatusDaQueixa(Long id, int situacao) {

        Queixa currentQueixa = this.queixas.get(id);
        if(currentQueixa != null){
            currentQueixa.setSituacao(verificaQueixa(situacao));
            saveQueixaExistente(currentQueixa);
        }

    }



    @Override
    public void fecharQueixa(Long id, String comentario) throws ObjetoInvalidoException {

        Queixa currentQueixa = this.queixas.get(id);
        currentQueixa.fechar(comentario);
        saveQueixaExistente(currentQueixa);

    }

    private void saveQueixaExistente(Queixa queixa){
        this.queixas.put(queixa.getId(), queixa);
    }

    /**
     * Retorna o status (enum) de uma queixa dado um codigo
     * @param situacao - codigo da situacao
     * @return - enum que representa a situação
     *
     */
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
