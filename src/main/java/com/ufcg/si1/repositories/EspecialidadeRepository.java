package com.ufcg.si1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufcg.si1.model.Especialidade;
@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade,  Long> {

	
	List<Especialidade> findAll();

	Especialidade findById(long id);
	
	List<Especialidade> findByCodigo(int codigo);
	
}
