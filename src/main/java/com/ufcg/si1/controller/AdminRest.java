package com.ufcg.si1.controller;

import com.ufcg.si1.controller.prefeitura.Prefeitura;
import com.ufcg.si1.exceptions.AdministradorException;
import com.ufcg.si1.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * Created by sampaio on 17/08/17.
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminRest {

    @Autowired
    private Prefeitura prefeitura;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Administrador>> getTodosOsAdministradores() {

        Collection<Administrador> admins = prefeitura.getAllAdministrador();

        if (admins.isEmpty()) {
            return new ResponseEntity(admins, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Collection<Administrador>>(admins, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Administrador> adicionaAdministrador(@RequestBody Administrador admin){

        try{
            Administrador admSalvo = prefeitura.adicionaAdministrador(admin);
            return new ResponseEntity<Administrador>(admSalvo, HttpStatus.OK);
        } catch (AdministradorException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Administrador> realizaLogin(@RequestBody Administrador admin){
        try{
            Administrador admLogado = prefeitura.realizaLogin(admin);
            return new ResponseEntity<Administrador>(admLogado, HttpStatus.OK);
        } catch (AdministradorException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }


}
