package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;
import org.junit.*;

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


    @Before
    public void setup() {
        queixaService = new QueixaServiceImpl();
        dummyQueixas();
    }


    @Test
    public void testaEficienciaDoAtendimento() throws Exception {

        Assert.assertEquals(0, queixaService.getQueixaAbertaPorcentagem(), 0.005);

        queixaService.abrirQueixa(new Queixa(4, "comi uma lomba e to me cagando todin",
                Queixa.ABERTA, "", "Jose Silva",
                "jose@gmail.com", "rua dos loco", "PE", "Pedregal"));

        queixaService.abrirQueixa(new Queixa(5, "que?",
                Queixa.ABERTA, "", "Jose",
                "jose@gmail.com", "rua dos loco", "PE", "Belavista"));

        Assert.assertEquals(0.4, queixaService.getQueixaAbertaPorcentagem(), 0.005);

        queixaService.deleteQueixaById(1);
        queixaService.deleteQueixaById(2);
        queixaService.deleteQueixaById(3);

        Assert.assertEquals(1.0, queixaService.getQueixaAbertaPorcentagem(), 0.005);
    }

    @Test
    public void modificaEFechaQueixas() throws Exception {
        //US4: das que precisam ser adicionadas


        queixaService.abrirQueixa(new Queixa(4, "comi uma lomba e to me cagando todin",
                Queixa.ABERTA, "", "Jose Silva",
                "jose@gmail.com", "rua dos loco", "PE", "Pedregal"));

        Assert.assertEquals(4, queixaService.size());

        queixaService.abrirQueixa(new Queixa(5, "que?",
                Queixa.ABERTA, "", "Jose",
                "jose@gmail.com", "rua dos loco", "PE", "Belavista"));

        Assert.assertEquals(5, queixaService.size());

        Assert.assertEquals(true, queixaService.isAberta(new Long(4)));

        //Esse número mágico Queixa.FECHADA precisa ser trocado por um enum.
        queixaService.modificaStatusDaQueixa(new Long(4), Queixa.FECHADA);
        Assert.assertEquals(false, queixaService.isAberta(new Long(4)));

        try{
            queixaService.modificaStatusDaQueixa(new Long(4), Queixa.ABERTA);
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
    public void testeQueixaSobreAnimais() throws Exception {

        queixaService.abrirQueixa(new Queixa(97, TIPO_QUEIXA.ANIMAL,"Cachorros",
                "Tem uns dog aqui na rua embassando?",
                Queixa.ABERTA, "", "Jose",
                "jose@gmail.com", "rua dos catiorros", "PB", "Olivedos"));

        Assert.assertEquals(4, queixaService.size());
        Assert.assertEquals(0.25, queixaService.getQueixaAbertaPorcentagem(), 0.005);

        queixaService.fecharQueixa(new Long(97), "Os cachorros já forem recolhidos e se encontram no abrigo de animais");

        Assert.assertEquals(0.0, queixaService.getQueixaAbertaPorcentagem(), 0.005);

        Assert.assertEquals(false, queixaService.isAberta(new Long(97)));

    }

    @Test
    public void testeDeletaQueixas() throws Exception {

        Assert.assertEquals(3, queixaService.size());

        queixaService.deleteQueixaById(1);
        Assert.assertEquals(2, queixaService.size());

        queixaService.deleteQueixaById(2);
        Assert.assertEquals(1, queixaService.size());

        queixaService.deleteQueixaById(3);
        Assert.assertEquals(0, queixaService.size());

        try{
            queixaService.deleteQueixaById(1);
        } catch (Exception e){

            Assert.assertEquals(QUEIXA_INEXISTENTE, e.getMessage());
            //tem que executar estas linhas
            fail();

        }

    }

    @Test
    public void testeFindByIdAndEquals() throws Exception {

        Queixa q1 = new Queixa(1, "Passei mal com uma coxinha",
                Queixa.FECHADA, "", "Jose Silva",
                "jose@gmail.com", "rua dos tolos", "PE", "Recife");

        Assert.assertEquals(q1, queixaService.findById(1));

        Assert.assertNotEquals(q1, queixaService.findById(2));

        try{
            Queixa q = queixaService.findById(99);
        } catch (Exception e){
            Assert.assertEquals(QUEIXA_INEXISTENTE, e.getMessage());
            fail();
        }


    }




    private void dummyQueixas(){

        queixaService.abrirQueixa(new Queixa(1, "Passei mal com uma coxinha",
                Queixa.FECHADA, "", "Jose Silva",
                "jose@gmail.com", "rua dos tolos", "PE", "Recife"));

        queixaService.abrirQueixa(new Queixa(2, "to lascadao aqui vei",
                Queixa.FECHADA, "se fodeu", "Jose Silva",
                "jose@gmail.com", "rua dos tolos", "PE", "PERNAMBUCO"));

        queixaService.abrirQueixa(new Queixa(3, "comprei uma parada estragada",
                Queixa.FECHADA, "se fodeu", "zezin",
                "jose@gmail.com", "rua dos tolos", "DF", "PARAIBA"));
    }

}