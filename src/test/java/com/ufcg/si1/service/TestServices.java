package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;
import org.junit.*;

/**
 * Testes para os services do sistema disque-saúde.
 *
 * Services cobertos por estas suítes:
 *
 *      - QueixaService
 *
 * Created by sampaio on 03/08/17.
 */
public class TestServices {

    private QueixaService queixaService;

    @Before
    public void setup() {
        queixaService = new QueixaServiceImpl();
        dummyQueixas();
    }


    @Test
    public void testaEficienciaDoAtendimento() throws Exception {

        Assert.assertEquals(0, queixaService.getQueixaEficiencia(), 0.005);

        queixaService.abrirQueixa(new Queixa(4, "comi uma lomba e to me cagando todin",
                Queixa.ABERTA, "", "Jose Silva",
                "jose@gmail.com", "rua dos loco", "PE", "Pedregal"));

        queixaService.abrirQueixa(new Queixa(5, "que?",
                Queixa.ABERTA, "", "Jose",
                "jose@gmail.com", "rua dos loco", "PE", "Belavista"));

        Assert.assertEquals(0.4, queixaService.getQueixaEficiencia(), 0.005);

        queixaService.deleteQueixaById(1);
        queixaService.deleteQueixaById(2);
        queixaService.deleteQueixaById(3);

        Assert.assertEquals(1.0, queixaService.getQueixaEficiencia(), 0.005);
    }

    @Test
    public void test2() throws Exception {
        // Test something else.
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
                "jose@gmail.com", "rua dos tolos", "DF", "PRAIBA"));
    }

}