package com.example.algaworks.algamoney.api.repository.Lancamento;

import com.example.algaworks.algamoney.api.model.Lancamento;
import com.example.algaworks.algamoney.api.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRespositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
