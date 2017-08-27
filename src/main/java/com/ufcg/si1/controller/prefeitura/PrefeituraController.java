package com.ufcg.si1.controller.prefeitura;

import com.ufcg.si1.exceptions.*;
import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.model.form.QueixaForm;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.AdministradorService;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.factory.QueixaFactory;
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
    @Autowired
    private AdministradorService administradorService;

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
            Queixa queixaAtualizada = verificaEAtualizaQueixa(id, queixa);
            return queixaService.updateQueixa(queixaAtualizada);
        }else{
            throw new QueixaInexistenteException();
        }
    }

    private Queixa verificaEAtualizaQueixa(Long id, QueixaForm queixaForm) throws QueixaException {

        Queixa queixa = queixaService.findById(id);
        Queixa queixaCriada = QueixaFactory.createQueixa(queixaForm);

        if(queixaCriada.equals(queixa)){
            queixa.setDescricao(queixaCriada.getDescricao());
            queixa.setComentario(queixaCriada.getComentario());
        }else {
            throw new QueixaNotEqualsException();
        }

        return queixa;

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

    @Override
    public Administrador realizaLogin(Administrador adm) throws AdministradorException {
        Administrador adminLogado = administradorService.realizarLogin(adm);
        if (adminLogado != null){
            return adminLogado;
        }else{
            throw new AdministradorException("deu erro no login");
        }
    }

    @Override
    public Administrador adicionaAdministrador(Administrador adm) throws AdministradorException {
        return administradorService.addNovoAdministrador(adm);
    }

    @Override
    public Collection<Administrador> getAllAdministrador() {
        return administradorService.getAllAdministrador();
    }

}
