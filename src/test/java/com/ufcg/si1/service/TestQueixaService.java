package com.ufcg.si1.service;

import com.ufcg.si1.model.Pessoa;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.repositories.QueixaRepository;
import com.ufcg.si1.exceptions.QueixaRegistradaException;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.fail;

/**
 * Testes para os os comportamento de QueixaService.
 * Estas suites foram feitas utilizando a abordagem de testes caixa-preta.
 *  *
 * Created by sampaio on 03/08/17.
 */
public class TestQueixaService {


    private QueixaService queixaService;
    private static final String QUEIXA_ENCERRADA_EXCEPTION = "Queixa já foi fechada. Não pode ser reaberta";
    private static final String QUEIXA_INEXISTENTE = "Queixa inexistente";

    private static final Queixa queixaDummy1 = new Queixa("Passei mal com uma coxinha",
            3, "", new Pessoa("Jose Silva",
            "jose@gmail.com", "rua dos tolos", "PE", "Recife"));

    private static final Queixa queixaDummy2 = new Queixa( "to lascadao aqui vei",
            3, "se fodeu", new Pessoa("Jose Silva",
            "j123ose@gmail.com", "rua dos tolos", "PE", "PERNAMBUCO"));

    private static final Queixa queixaDummy3 = new Queixa("comprei uma parada estragada",
            3, "se fodeu", new Pessoa("zezin",
            "jose@gmail.com", "rua dos tolos", "DF", "PARAIBA"));


    @Autowired
    QueixaRepository queixaRepository;

    @Before
    public void setup() throws QueixaRegistradaException {
        queixaService = new QueixaServiceImpl();
        dummyQueixas();
    }


    @Test
    public void testaEficienciaDoAtendimento() throws Exception {

        Assert.assertEquals(0, queixaService.getQueixaAbertaPorcentagem(), 0.005);

        Queixa queixa1 = new Queixa("comi uma lomba e to me cagando todin",
                1, "", new Pessoa("Jose Silva",
                "jose@gmail.com", "rua dos loco", "PE", "Pedregal"));

        Queixa queixa2 = new Queixa("que?",
                1, "", new Pessoa("Jose",
                "jose@gmail.com", "rua dos loco", "PE", "Belavista"));

        queixaService.abrirQueixa(queixa1);

        queixaService.abrirQueixa(queixa2);

        Assert.assertEquals(0.4, queixaService.getQueixaAbertaPorcentagem(), 0.005);

        queixaService.deleteQueixaById(queixaDummy1.getId());
        queixaService.deleteQueixaById(queixaDummy2.getId());
        queixaService.deleteQueixaById(queixaDummy3.getId());

        Assert.assertEquals(1.0, queixaService.getQueixaAbertaPorcentagem(), 0.005);
    }

    @Test
    public void modificaEFechaQueixas() throws Exception {
        //US4: das que precisam ser adicionadas


        queixaService.abrirQueixa(new Queixa( "comi uma lomba e to me cagando todin",
                1, "", new Pessoa("Jose Silva",
                "jose@gmail.com", "rua dos loco", "PE", "Pedregal")));

        Assert.assertEquals(4, queixaService.size());

        queixaService.abrirQueixa(new Queixa( "que?",
                1, "", new Pessoa("Jose do rego",
                "jose@gmail.com", "rua dos loco", "PE", "Belavista")));

        Assert.assertEquals(5, queixaService.size());

        Assert.assertEquals(true, queixaService.isAberta(new Long(4)));

        //Esse número mágico Queixa.FECHADA precisa ser trocado por um enum.
        queixaService.fecharQueixa(new Long(4), "fechada");
        Assert.assertEquals(false, queixaService.isAberta(new Long(4)));

        try{
            queixaService.fecharQueixa(new Long(4), "fechando de novo");
        } catch (Exception e){
            Assert.assertEquals(QUEIXA_ENCERRADA_EXCEPTION, e.getMessage());
            //esta linha precisa ser executada
            fail();

        }

        queixaService.fecharQueixa(new Long(5), "A unidade já foi contactada e as medidas cabíveis já estão sendo tomadas");

        Assert.assertEquals(false, queixaService.isAberta(new Long(5)));

        Assert.assertEquals(0, queixaService.getQueixaAbertaPorcentagem(), 0.005);

    }


    @Test
    public void testeDeletaQueixas() throws Exception {

        Assert.assertEquals(3, queixaService.size());

        queixaService.deleteQueixaById(queixaDummy1.getId());
        Assert.assertEquals(2, queixaService.size());

        queixaService.deleteQueixaById(queixaDummy2.getId());
        Assert.assertEquals(1, queixaService.size());

        queixaService.deleteQueixaById(queixaDummy3.getId());
        Assert.assertEquals(0, queixaService.size());

        try{
            queixaService.deleteQueixaById(queixaDummy1.getId());
        } catch (Exception e){

            Assert.assertEquals(QUEIXA_INEXISTENTE, e.getMessage());
            //tem que executar estas linhas
            fail();

        }

    }

    @Test
    public void testeFindByIdAndEquals() throws Exception {

        Queixa q1 = new Queixa("Passei mal com uma coxinha",
               3, "", new Pessoa("Jose Silva",
                "jose@gmail.com", "rua dos tolos", "PE", "Recife"));

        Assert.assertEquals(q1, queixaService.findById(q1.getId()));

        Assert.assertNotEquals(q1, queixaService.findById(queixaDummy1.getId()));

        try{
            Queixa q = queixaService.findById(new Long(-69));
        } catch (Exception e){
            Assert.assertEquals(QUEIXA_INEXISTENTE, e.getMessage());
            fail();
        }


    }



    private void dummyQueixas() throws QueixaRegistradaException {

        queixaService.abrirQueixa(queixaDummy1);

        queixaService.abrirQueixa(queixaDummy2);

        queixaService.abrirQueixa(queixaDummy3);
    }

}