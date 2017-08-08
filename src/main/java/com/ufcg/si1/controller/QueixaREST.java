package com.ufcg.si1.controller;

import java.util.List;

import javax.ejb.EJB;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.util.CustomErrorType;

import exceptions.ObjetoInvalidoException;

@RestController
@RequestMapping("/queixa")
@CrossOrigin
public class QueixaREST {
	
	@EJB
	private QueixaService queixaService;
	
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
	@RequestMapping(value = "/queixa/", method = RequestMethod.GET)
    public ResponseEntity<List<Queixa>> listAllUsers() {
        List<Queixa> queixas = queixaService.findAllQueixas();

        if (queixas.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
    }
	
	/**
	 * URI do recurso: /queixa
	 * 
	 * Método de submissão POST para cadastrar uma nova queixa.
	 * @param queixa
	 * 				Queixa a ser cadastrada
	 * @param ucBuilder
	 * 					????????????????????????
	 * @return
	 * 			Response com o sucesso ou não da requisição
	 */
	@RequestMapping(value = "/queixa/", method = RequestMethod.POST)
    public ResponseEntity<?> abrirQueixa(@RequestBody Queixa queixa, UriComponentsBuilder ucBuilder) {
        try {
            queixa.abrir();
        } catch (ObjetoInvalidoException e) {
            return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
        }
        queixaService.saveQueixa(queixa);

        return new ResponseEntity<Queixa>(queixa, HttpStatus.CREATED);
    }
	
	/** URI do recurso: /queixa/{id}
	 *  Método de acesso GET para recuperar uma queixa específica.
	 * @param id
	 * 			ID da queixa a ser recuperada
	 * @return
	 * 			Response com o sucesso ou não da requisição. Para o
	 * 			caso de sucesso o recurso requisitado também será enviado.
	 */
	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarQueixa(@PathVariable("id") long id) {

        Queixa q = queixaService.findById(id);
        if (q == null) {
            return new ResponseEntity(new CustomErrorType("Queixa with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Queixa>(q, HttpStatus.OK);
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
	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateQueixa(@PathVariable("id") long id, @RequestBody Queixa queixa) {

        Queixa currentQueixa = queixaService.findById(id);

        if (currentQueixa == null) {
            return new ResponseEntity(new CustomErrorType("Unable to upate. Queixa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentQueixa.setDescricao(queixa.getDescricao());
        currentQueixa.setComentario(queixa.getComentario());

        queixaService.updateQueixa(currentQueixa);
        return new ResponseEntity<Queixa>(currentQueixa, HttpStatus.OK);
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
	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {

        Queixa user = queixaService.findById(id);
        if (user == null) {
            return new ResponseEntity(new CustomErrorType("Unable to delete. Queixa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        queixaService.deleteQueixaById(id);
        return new ResponseEntity<Queixa>(HttpStatus.NO_CONTENT);
    }
	
	/**
	 * URI do recurso: /queixa/fechamento
	 * 
	 * Método de submissão POST para fechar uma Queixa específica.
	 * @param queixaAFechar
	 * 		 	Queixa a ser fechada.
	 * @return
	 * 			Response com o sucesso ou não da requisição.
	 */
	@RequestMapping(value = "/queixa/fechamento", method = RequestMethod.POST)
    public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) {
        queixaAFechar.situacao = Queixa.FECHADA;
        queixaService.updateQueixa(queixaAFechar);
        return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);
    }
}
