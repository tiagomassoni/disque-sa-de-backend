package com.ufcg.si1.model;

import com.ufcg.si1.model.Queixa;

import exceptions.ObjetoInvalidoException;

import org.junit.*;

/**
 * Teste para a entidade Queixa
 * 
 * @author Tiago
 *
 */
public class TestQueixa {

	private Queixa queixa1;
	private Queixa queixa2;
	private Queixa queixa3;
	
	@Before
	public void setup() {
		queixa1 = new Queixa(5, "Comi uma teju e vomitei", 1, "",
                "Taigo", "taigo@gmailcom",
				  "Idelfonso Aires", "Paraiba", "Campina Grande");
		queixa2 = new Queixa(6, "Bati um lampião de gás na cabeça", 2, "",
                "Ednaldo Pereira", "ednaldo@gmailcom",
				  "Cachoeira dos Guedes", "Paraiba", "Guarabira");
		queixa3 = new Queixa(7, "Tomei muitos ansiolíticos de uma vez", 3, "",
                "Priscyla", "pri@gmailcom",
				  "Rua João Maurício", "Paraiba", "João Pessoa");
	}
		
	@Test
	public void abrir() {
		try {
			Assert.assertEquals(3, queixa3.getSituacao());
			queixa3.abrir();
			Assert.assertEquals(1, queixa3.getSituacao());
		} catch (ObjetoInvalidoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void abrirException() {
		try {
			queixa2.abrir();
		} catch (ObjetoInvalidoException e) {
			Assert.assertEquals("ExcecaoDados: Status inválido", e.getMessage());
		}
	}
	
	@Test
	public void fechar() {
		try {
			Assert.assertEquals(1, queixa1.getSituacao());
			queixa1.fechar("Passou");
			Assert.assertEquals(3, queixa1.getSituacao());
			
			Assert.assertEquals(2, queixa2.getSituacao());
			queixa2.fechar("Nunca não");
			Assert.assertEquals(3, queixa2.getSituacao());
		} catch (ObjetoInvalidoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void fecharException() {
		try {
			queixa3.fechar("Foi sem querer");
		} catch (ObjetoInvalidoException e) {
			Assert.assertEquals("ExcecaoDados: Statusinválido", e.getMessage());
		}
	}
}