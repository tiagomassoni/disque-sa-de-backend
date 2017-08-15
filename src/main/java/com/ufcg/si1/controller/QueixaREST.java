package com.ufcg.si1.controller;

import java.util.Collection;

import com.ufcg.si1.controller.prefeitura.Prefeitura;
import com.ufcg.si1.model.form.QueixaForm;
import com.ufcg.si1.exceptions.QueixaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;


@RestController
@RequestMapping("/api/queixa")
@CrossOrigin
public class QueixaREST {

    @Autowired
    private QueixaService queixaService;

    @Autowired
    private Prefeitura prefeitura;

    /* situação normal =0
        situação extra =1
     */
    private int situacaoAtualPrefeitura = 0;

    /**
     * URI do recurso: /queixa
     *
     * Método de acesso GET para listar todas as queixas cadastradas
     * no sistema.
     * @return Response com o sucesso ou não da requisição. Para o
     * 		   caso de sucesso, o recurso requisitado também será
     * 		   enviado.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Queixa>> getAllQueixas() {

        Collection<Queixa> queixas = prefeitura.getTodasAsQueixas();

        if (queixas.isEmpty()) {
            return new ResponseEntity(queixas, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Collection<Queixa>>(queixas, HttpStatus.OK);
    }

    /**
     * URI do recurso: /queixa
     *
     * Método de submissão POST para cadastrar uma nova queixa.
     * @param queixa
     * 				Queixa a ser cadastrada
     *
     * @return
     * 			Response com o sucesso ou não da requisição
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Queixa> abrirQueixa(@RequestBody QueixaForm queixa) throws QueixaException {

        ResponseEntity response;

        try {
            Queixa queixaAberta = prefeitura.abrirQueixa(queixa);
            return new ResponseEntity<Queixa>(queixaAberta, HttpStatus.CREATED);
        } catch (QueixaException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    /** URI do recurso: /queixa/{id}
     *  Método de acesso GET para recuperar uma queixa específica.
     * @param id
     * 			ID da queixa a ser recuperada
     * @return
     * 			Response com o sucesso ou não da requisição. Para o
     * 			caso de sucesso o recurso requisitado também será enviado.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarQueixa(@PathVariable("id") Long id) {

        try{
            Queixa queixaConsultada = prefeitura.consultarQueixa(id);
            return new ResponseEntity(queixaConsultada, HttpStatus.OK);
        } catch (QueixaException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    /**
     * URI do recurso: /queixa/{id}
     *
     * Método de submissão PUT para atualizar uma queixa específica.
     * @param id
     * 			ID da queixa a ser atualizada
     * @param queixa
     * 			Queixa a ser atualizada
     * @return
     * 			Response com o sucesso ou não da requisição. Para o
     * 			caso de sucesso o recurso requisitado também será enviado.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Queixa> updateQueixa(@PathVariable("id") Long id, @RequestBody QueixaForm queixa) throws QueixaException {

        try{
            Queixa queixaAtualizada = prefeitura.updateQueixa(id, queixa);
            return new ResponseEntity(queixaAtualizada, HttpStatus.OK);
        }catch (QueixaException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * URI do recurso: /queixa/{id}
     *
     * Método DELETE para excluir uma Queixa específica.
     * @param id
     * 			ID da queixa
     * @return
     * 		   Response com o sucesso ou não da requisição.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Queixa> deleteQueixa(@PathVariable("id") Long id) throws QueixaException {

        try{
            Queixa queixaApagada = prefeitura.deleteQueixa(id);
            return new ResponseEntity(queixaApagada,HttpStatus.OK );
        }catch (QueixaException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

     //TODO: DOCs, não tá passando o comentário da queixa,
    @RequestMapping(value = "/fechamento/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> fecharQueixa(@PathVariable Long id, @RequestBody String comentario) throws QueixaException {

        try{
            Queixa queixaFechada = prefeitura.fecharQueixa(id, comentario);
            return new ResponseEntity(queixaFechada, HttpStatus.OK);
        } catch (QueixaException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
