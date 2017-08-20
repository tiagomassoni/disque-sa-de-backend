package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.repositories.EspecialidadeRepository;
import com.ufcg.si1.exceptions.ObjetoInexistenteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	//Este método ainda nao faz sentido pra atual implementação,
	//mas pode fazer caso a estratégia mude
    @Override
    public List<Especialidade> getListaEspecialidade() {
    	return especialidadeRepository.findAll();
    }

    @Override
    public void insere(Especialidade esp){
    	especialidadeRepository.save(esp);
    }

    //Assim como esse também nao
    @Override
    public boolean existe(int codigo) {
        if(especialidadeRepository.findByCodigo(codigo) != null) {
        	return true;
        } return false;
    }

	@Override
	public Especialidade findById(long id) {
		return especialidadeRepository.findById(id);
	}

	@Override
	public List<Long> unidadesComEsecialidade(int codigo) {
		List<Especialidade> esp = especialidadeRepository.findByCodigo(codigo);
		List<Long> idUnidades = new ArrayList<>();
		
		for (Especialidade especialidade: esp) {
			idUnidades.add(especialidade.getIdUs());
		}
		
		return idUnidades;
	}


}
