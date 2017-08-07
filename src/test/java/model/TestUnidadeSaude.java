package model;

import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class TestUnidadeSaude {
	
	
	private UnidadeSaude unidadeCatole;
	private UnidadeSaude unidadeTambor;
	private UnidadeSaudeServiceImpl service;
	
	public final static String EnderecoCatole = "Rua Ednaldo Pereira, 666, Catolé";
	public final static String EnderecoTambor ="Rua Se Juntas ja causa imagina juntas, 598, Tambor";
	

	
	@Before
	public void setUp() {
		unidadeCatole = new PostoSaude(EnderecoCatole, 4, 3);
		unidadeTambor = new PostoSaude(EnderecoTambor, 8, 3);
		service = new UnidadeSaudeServiceImpl();
	}
	
	
	public void insereCatoleETambor() {
		try {
			service.insere(unidadeTambor);
			service.insere(unidadeCatole);
		} catch (Rep | ObjetoJaExistenteException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void insereUnidade() {
		insereCatoleETambor();
		assertEquals(service.existe(2), true);
		assertEquals(service.existe(1), true);

		try {
			service.insere(unidadeTambor);
		} catch (Rep | ObjetoJaExistenteException e) {
			assertEquals(e.getMessage(), "ExcecaoDados: Objeto jah existe no array");
		}
		
	}
	
	
	@Test
	public void procuraUnidadeCodigo() throws Rep, ObjetoInexistenteException {
		insereCatoleETambor();
		assertEquals(service.procura(2), unidadeCatole);
		assertEquals(service.procura(1), unidadeTambor);
		 
	}
	
	@Test
	public void procuraPorBairro() {
		insereCatoleETambor();
		assertEquals(service.findByBairro(EnderecoCatole), unidadeCatole);
		assertEquals(service.findByBairro(EnderecoTambor), unidadeTambor);


		
	}
	
	
	

}
