package com.ufcg.si1.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.si1.model.UnidadeSaude;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UnidadeSaudeRepository extends JpaRepository<UnidadeSaude,  Long>{


	/**
	 * Serviço que retorna uma única unidade de saude a partir do id.
	 * 
	 * @param id
	 * @return unidade de saude com id especificado
	 */
	UnidadeSaude findById(Long id);
	

	
}
