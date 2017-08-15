package com.ufcg.si1.controller.prefeitura;

import com.ufcg.si1.model.form.QueixaForm;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.factory.QueixaFactory;
import com.ufcg.si1.exceptions.QueixaException;
import com.ufcg.si1.exceptions.QueixaInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

/**
 * Created by sampaio on 15/08/17.
 */
@Controller
public class PrefeituraController implements Prefeitura {

    //TODO: Strategy[n decidido ainda] com situaçao da prefeitura (normal ou extra)

    @Autowired
    private QueixaService queixaService;

    @Override
    public Queixa abrirQueixa(QueixaForm queixaForm) throws QueixaException {

       Queixa queixa = QueixaFactory.createQueixa(queixaForm);
       return queixaService.abrirQueixa(queixa);

    }

    @Override
    public Collection<Queixa> getTodasAsQueixas() {
        return queixaService.findAllQueixas();
    }

    @Override
    public Queixa consultarQueixa(Long id) throws QueixaException {

        if(queixaService.existeQueixa(id)){
            return queixaService.findById(id);
        }else{
            throw new QueixaInexistenteException();
        }

    }

    @Override
    public Queixa updateQueixa(Long id, QueixaForm queixa) throws QueixaException {

        if(queixaService.existeQueixa(id)){
            Queixa queixaCriada = queixaService.findById(id);
            queixaCriada.setComentario(queixa.getComentario());
            queixaCriada.setDescricao(queixa.getDescricao());
            return queixaService.updateQueixa(queixaCriada);
        }else{
            throw new QueixaInexistenteException();
        }

    }

    @Override
    public Queixa deleteQueixa(Long id) throws QueixaException {

        if(queixaService.existeQueixa(id)){

            return queixaService.deleteQueixaById(id);
        }else{
            throw new QueixaInexistenteException();
        }

    }

    @Override
    public Queixa fecharQueixa(Long id, String comentario) throws QueixaException {

        if(queixaService.existeQueixa(id)){
            return queixaService.fecharQueixa(id, comentario);

        }else{
            throw new QueixaInexistenteException();
        }

    }

}
