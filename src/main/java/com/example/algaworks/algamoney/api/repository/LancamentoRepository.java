package com.example.algaworks.algamoney.api.repository;

import com.example.algaworks.algamoney.api.model.Lancamento;
import com.example.algaworks.algamoney.api.repository.Lancamento.LancamentoRespositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LancamentoRepository extends JpaRepository<Lancamento,Long>, LancamentoRespositoryQuery {


}
