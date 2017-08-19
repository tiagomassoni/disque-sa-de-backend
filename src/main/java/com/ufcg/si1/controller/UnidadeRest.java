package com.ufcg.si1.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import com.ufcg.si1.exceptions.ObjetoJaExistenteException;
import com.ufcg.si1.exceptions.Rep;

@RestController
@RequestMapping("/api/unidade")
@CrossOrigin
public class UnidadeRest {

	@Autowired
	private UnidadeSaudeService unidadeSaudeService;

	/**
	 * URI do recurso: /unidade/especialidade
	 *
	 * Método de acesso GET para listar todas as especialidades da
	 * unidade.
	 * @return Response com o sucesso ou não da requisição. Para o
	 * 		   caso de sucesso, o recurso requisitado também será
	 * 		   enviado.
	 */
	@RequestMapping(value = "/especialidade", method = RequestMethod.GET)
	public ResponseEntity<?> consultaEspecialidadeporUnidadeSaude(@RequestBody Long codigoUnidadeSaude) {

		List<Especialidade> especialidades = unidadeSaudeService.especialidadesPorUnidade(codigoUnidadeSaude);

		if (!especialidades.isEmpty()) {
			return new ResponseEntity<>(especialidades, HttpStatus.OK);
		}

		return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
	}

	/**
	 * URI do recurso: /unidade
	 *
	 * Método de acesso GET para listar todas as unidades cadastradas
	 * no sistema.
	 * @return Response com o sucesso ou não da requisição. Para o
	 * 		   caso de sucesso, o recurso requisitado também será
	 * 		   enviado.
	 */
	@RequestMapping(value = "/todasAsUnidades", method = RequestMethod.GET)
	public ResponseEntity<Collection<UnidadeSaude>> getAllUnidades() {


		Collection<UnidadeSaude> todasUnidades = unidadeSaudeService.getAll();

		if (!todasUnidades.isEmpty()) {
			return new ResponseEntity<Collection<UnidadeSaude>>(todasUnidades, HttpStatus.OK);
		}
		return new ResponseEntity<Collection<UnidadeSaude>>(HttpStatus.NOT_FOUND);
	}

	/**
	 * URI do recurso: /unidade
	 *
	 * Método de submissão POST para cadastrar uma nova Unidade.
	 * @param us
	 * 			unidade de saude a ser criada
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/incluirUnidade", method = RequestMethod.POST)
	public ResponseEntity<UnidadeSaude> incluirUnidadeSaude(@RequestBody UnidadeSaude us) {
				
		try {
			unidadeSaudeService.insere(us);
			 return new ResponseEntity<UnidadeSaude>(HttpStatus.CREATED);
		} catch (Rep e) {
			return new ResponseEntity<UnidadeSaude>(HttpStatus.BAD_REQUEST);
		} catch (ObjetoJaExistenteException e) {
			return new ResponseEntity<UnidadeSaude>(HttpStatus.CONFLICT);
		}

	}

	/**
	 * URI do recurso: /{id}
	 *
	 * Método de acesso GET para retornar unidade pelo codigo de identificação
	 *
	 * @return Response com o sucesso ou não da requisição. Para o
	 * 		   caso de sucesso, o recurso requisitado também será
	 * 		   enviado.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") long id) {

		UnidadeSaude us = unidadeSaudeService.findById(id);
		if (us == null) {
			return new ResponseEntity<>(new CustomErrorType("Unidade with id " + id
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(us, HttpStatus.OK);
	}


	/**
	 * URI do recurso: /busca
	 *
	 * Método de acesso GET para listar unidades de um determinado bairro.
	 *
	 * @return Response com o sucesso ou não da requisição. Para o
	 * 		   caso de sucesso, o recurso requisitado também será
	 * 		   enviado.
	 */
	@RequestMapping(value="/busca", method= RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaudePorBairro(@RequestParam(value = "bairro", required = true) String bairro){

		List<UnidadeSaude> unidadesDoBairro = unidadeSaudeService.findByBairro(bairro);
		if (!unidadesDoBairro.isEmpty()) {
			return new ResponseEntity<List>(unidadesDoBairro, HttpStatus.OK);
		}
		return new ResponseEntity(new CustomErrorType("Unidade with bairro " + bairro
				+ " not found"), HttpStatus.NOT_FOUND);
	}



	/**
	 * URI do recurso: /medicos/{id}
	 *
	 * Método de acesso GET que retorna a eficiencia de uma Unidade de Saude.
	 *
	 * @return Response com o sucesso ou não da requisição. Para o
	 * 		   caso de sucesso, o recurso requisitado também será
	 * 		   enviado.
	 */
	@RequestMapping(value = "/medicos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") long id) {

		UnidadeSaude us = unidadeSaudeService.findById(id);

		if (us != null) {
			return new ResponseEntity<ObjWrapper<Double>>(new ObjWrapper<Double>(unidadeSaudeService.mediaMedica(us)), HttpStatus.OK);

		}
		return new ResponseEntity<ObjWrapper<Double>>(HttpStatus.NOT_FOUND);

	}
}
