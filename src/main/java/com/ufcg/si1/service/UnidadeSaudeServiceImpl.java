package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.RepositorioException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
    private UnidadeSaude[] vetor;

    private int indice;

    private int geraCodigo = 0; // para gerar codigos das queixas cadastradas

    public UnidadeSaudeServiceImpl() {
        vetor = new UnidadeSaude[100];
        indice = 0;
    }


    @Override
    public UnidadeSaude procura(int codigo) throws RepositorioException,
            ObjetoInexistenteException {

        int i = 0;

        while (i < indice) {
            if (vetor[i].getCodigo() == codigo) {
                return vetor[i];
            }

            i++;
        }

        throw new ObjetoInexistenteException("Não achou unidade");
    }

    @Override
    public List<UnidadeSaude> getAll() {
        return Arrays.asList(vetor);
    }

    @Override
    public void insere(UnidadeSaude us) throws RepositorioException,
            ObjetoJaExistenteException {

        us.setCodigo(++geraCodigo);
        if (indice == this.vetor.length) {
            throw new RepositorioException("Erro ao incluir no array");
        }

        if (this.existe(us.getCodigo())) {
            throw new ObjetoJaExistenteException("Objeto jah existe no array");
        }

        this.vetor[indice] = us;
        indice++;
    }

    @Override
    public boolean existe(int codigo) {
        int indiceAux = 0;
        boolean existe = false;

        for (int i = 0; i < indice; i++) {
            if (this.vetor[i].getCodigo() == codigo) {
                indiceAux = i;
                existe = true;

                break;
            }
        }

        return existe;
    }

    public UnidadeSaude findById(long id) {
        for (UnidadeSaude esp: vetor) {
            if (esp != null && esp.getCodigo() == id) {
                return esp;
            }
        }
        return null;
    }
}
