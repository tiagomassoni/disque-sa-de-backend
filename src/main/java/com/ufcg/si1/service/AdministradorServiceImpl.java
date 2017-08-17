package com.ufcg.si1.service;

import com.ufcg.si1.exceptions.AdministradorException;
import com.ufcg.si1.exceptions.AdministradorInexistenteException;
import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repositories.AdminstradorRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sampaio on 17/08/17.
 */
public class AdministradorServiceImpl implements AdminstradorService {

    @Autowired
    private AdminstradorRepository adminRepository;

    @Override
    public Administrador realizarLogin(Administrador adm) throws AdministradorException {

        if(existeAdministrador(adm.getEmail())){
            return adminRepository.findAdministradorByEmailAndPassword(adm.getEmail(), adm.getPassword());
        }else{
            throw new AdministradorInexistenteException();
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

    private boolean existeAdministrador(String email){
        return adminRepository.findAdministradorByEmail(email) != null;
    }

    private boolean confirmaCadastro(String email, String password){
        return adminRepository.findAdministradorByEmailAndPassword(email,password) != null;
    }
}
