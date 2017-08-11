package com.ufcg.si1.model;

import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;

import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUnidadeSaude {

	private UnidadeSaude unidadeCatole;
	private UnidadeSaude unidadeTambor;
	private UnidadeSaudeService service;
	private List<UnidadeSaude> listaUnidades;

	public final static String EnderecoCatole = "Rua Ednaldo Pereira, 666, Catolé";
	public final static String EnderecoTambor = "Rua Se Juntas ja causa imagina juntas, 598, Tambor";
	public final static String EnderecoInvalido = "Rua Sei Que Sei Que Lá, 000, Sem Bairro";

	@Before
	public void setUp() {
		unidadeCatole = new PostoSaude(EnderecoCatole, 4, 3);
		unidadeTambor = new PostoSaude(EnderecoTambor, 8, 3);
		service = new UnidadeSaudeServiceImpl();
		insereCatoleETambor();
	}

	private void insereCatoleETambor() {
		try {
			service.insere(unidadeTambor);
			service.insere(unidadeCatole);
		} catch (Rep | ObjetoJaExistenteException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void insereUnidade() {
		Assert.assertEquals(service.existe(new Long(2)), true);
		Assert.assertEquals(service.existe(new Long(1)), true);

		try {
			service.insere(unidadeTambor);
		} catch (Rep | ObjetoJaExistenteException e) {
			Assert.assertEquals(e.getMessage(), "ExcecaoDados: Objeto jah existe no array");
		}

	}

	@Test
	public void procuraUnidadeCodigo() {
		Assert.assertEquals(service.findById(1), unidadeTambor);
		Assert.assertEquals(service.findById(2), unidadeCatole);
		Assert.assertEquals(service.findById(3), null);

	}

	@Test
	public void procuraPorBairro() {
		Assert.assertEquals(service.findByBairro(EnderecoCatole), unidadeCatole);
		Assert.assertEquals(service.findByBairro(EnderecoTambor), unidadeTambor);
		Assert.assertEquals(service.findByBairro(EnderecoInvalido), null);
	}

	@Test
	public void unidadesExistentes() {
		listaUnidades = new ArrayList<UnidadeSaude>();
		listaUnidades.add(unidadeTambor);
		listaUnidades.add(unidadeCatole);
		
		Assert.assertEquals((listaUnidades), service.getAll());
	}

	@Test
	public void mediaMedicoPorPacientePostoDeSaude() {
		Assert.assertEquals(service.mediaMedica((Object) unidadeCatole), 1.33333333, 0.01);
		Assert.assertEquals(service.mediaMedica((Object) unidadeTambor), 2.66666666, 0.01);
	}

	@Test
	public void mediaMedicoPorPacienteUnidadeSaude() {
		// TODO: Nao consegui testar, a classe Hospital so esta disponivel como .jar
	}

}
