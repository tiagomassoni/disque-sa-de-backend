package com.ufcg.si1.service;

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
    }


    @Test
    public void test1() throws Exception {
        // This is where you call hermesClient or your client and test your service.
    }

    @Test
    public void test2() throws Exception {
        // Test something else.
    }

}