package com.example.algaworks.algamoney.api.repository.Lancamento;

import com.example.algaworks.algamoney.api.model.Lancamento;
import com.example.algaworks.algamoney.api.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRespositoryQuery {

    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
