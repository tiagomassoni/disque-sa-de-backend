package com.ufcg.si1.controller.prefeitura;

public class SituacaoNormal implements SituacaoPrefeitura {

	@Override
	// Vai ser uma string mesmo?
	public String getSituacaoQueixa(int queixasAbertas, int totalQueixas) {
		return (double) queixasAbertas / totalQueixas > 0.2 ? "ruim":"regular";
	}

}
