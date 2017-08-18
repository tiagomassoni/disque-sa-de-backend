package com.ufcg.si1.service;

import com.ufcg.si1.exceptions.AdministradorException;
import com.ufcg.si1.exceptions.AdministradorInexistenteException;
import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repositories.AdminstradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by sampaio on 17/08/17.
 */
@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdminstradorRepository adminRepository;

    @Override
    public Administrador realizarLogin(Administrador adm) throws AdministradorException {

        if(confirmaCadastro(adm.getEmail(), adm.getPassword())){
            return adminRepository.findByEmailAndPassword(adm.getEmail(), adm.getPassword());

        }else{
            throw new AdministradorException("Senha ou email incorretos");
        }


    }

    @Override
    public Administrador addNovoAdministrador(Administrador adm) throws AdministradorException {
        if(!existeAdministrador(adm.getEmail())){
            return adminRepository.save(adm);
        }else {
            throw new AdministradorException("Administrador já cadastrado.");
        }
    }

    @Override
    public Administrador atualizaAdministrador(Administrador adm) throws AdministradorException {

        if(confirmaCadastro(adm.getEmail(), adm.getPassword())){
            return adminRepository.save(adm);
        }else{
            throw new AdministradorException("Email ou Senha incorretos");
        }

    }

    @Override
    public Collection<Administrador> getAllAdministrador() {
        return adminRepository.findAll();
    }

    private boolean existeAdministrador(String email){
        return adminRepository.findByEmail(email) != null;
    }

    private boolean confirmaCadastro(String email, String password){
        return adminRepository.findByEmailAndPassword(email,password) != null;
    }
}
