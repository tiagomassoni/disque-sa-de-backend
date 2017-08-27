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

    @Override
    public void insere(Especialidade esp){
    	esp.setDescricao(esp.getDescricao().toLowerCase());
    	especialidadeRepository.save(esp);
    }

	@Override
	public Especialidade findById(long id) {
		return especialidadeRepository.findById(id);
	}

	@Override
	public List<Long> unidadesComEspecialidade(String descricao) {
		List<Especialidade> esp = especialidadeRepository.findByDescricao(descricao.toLowerCase());
		List<Long> idUnidades = new ArrayList<>();
		
		for (Especialidade especialidade: esp) {
			idUnidades.add(especialidade.getIdUs());
		}
		
		return idUnidades;
	}


}
