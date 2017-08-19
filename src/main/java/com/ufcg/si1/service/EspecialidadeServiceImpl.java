package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.repositories.EspecialidadeRepository;
import com.ufcg.si1.exceptions.ObjetoInexistenteException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {

	private EspecialidadeRepository especialidadeRepository;

    @Override
    public Especialidade procura(int codigo) throws ObjetoInexistenteException {
    	if (existe(codigo)) {
    		return especialidadeRepository.findBycodigo(codigo);
    	}
       
    	throw new ObjetoInexistenteException("Especialidade nao encontrada");
    }

    @Override
    public List<Especialidade> getListaEspecialidade() {
    	return especialidadeRepository.findAll();
    }

    @Override
    public void insere(Especialidade esp) throws Exception {
    	if(especialidadeRepository.findBycodigo(esp.getCodigo()) != null) {
    		throw new Exception();
    	} else {
    		especialidadeRepository.save(esp);
    	}
    }

    @Override
    public boolean existe(int codigo) {

        if(especialidadeRepository.findBycodigo(codigo) != null) {
        	return true;
        } return false;
    }

	@Override
	public Especialidade findById(long id) {
		return especialidadeRepository.findByid(id);
	}


}
