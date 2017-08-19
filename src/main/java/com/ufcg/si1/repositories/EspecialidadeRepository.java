package com.ufcg.si1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.si1.model.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade,  Long> {

	Especialidade findBycodigo(int codigo);
	
	List<Especialidade> findAll();

	Especialidade findByid(long id);
	
}
