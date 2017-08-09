package com.ufcg.si1.service;

import br.edu.ufcg.Hospital;

import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.UnidadeSaude;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
	private List<UnidadeSaude> unidades;

	private int geraCodigo = 0; // para gerar codigos das queixas cadastradas

	public UnidadeSaudeServiceImpl() {
		unidades = new ArrayList<UnidadeSaude>();

	}

	@Override
	public List<UnidadeSaude> getAll() {
		return unidades;
	}

	@Override
	public void insere(UnidadeSaude unidade) {
		if (!existe(unidade.pegaCodigo())) {
			geraCodigo++;
			unidade.mudaCodigo(geraCodigo);
			unidades.add(unidade);

		}

	}

	@Override
	public boolean existe(int codigo) {
		boolean existe = false;
		for (UnidadeSaude unidadeSaude : unidades) {
			if (unidadeSaude.pegaCodigo() == codigo) {
				existe = true;
			}
		}

		return existe;
	}

	public UnidadeSaude findById(long id) {
		UnidadeSaude resultadoBusca = null;
		for (UnidadeSaude unidadeSaude : unidades) {
			if (unidadeSaude.pegaCodigo() == id) {
				resultadoBusca = unidadeSaude;
			}
		}

		return resultadoBusca;
	}

	@Override
	public Object findByBairro(String bairro) {
		UnidadeSaude resultadoBairro = null;
		for (UnidadeSaude unidadeSaude : unidades) {
			if (unidadeSaude.pegaDescricao().equals(bairro)) {
				resultadoBairro = unidadeSaude;
			}
		}

		return resultadoBairro;
	}

	public Double mediaMedica(Object unidade) {
		double c = 0.0;
		if (unidade instanceof PostoSaude)
			c = ((PostoSaude) unidade).getAtendentes() / ((PostoSaude) unidade).taxaDiaria();
		else if (unidade instanceof Hospital) {
			c = ((Hospital) unidade).getNumeroMedicos() / ((Hospital) unidade).getNumeroPacientesDia();
		}
		return c;
	}
}
