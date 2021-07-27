package com.example.algaworks.algamoney.api.repository.filter;

import java.time.LocalDate;

public class LancamentoFilter {

    private String descricao;
    private LocalDate dataVencimentoDe;
    private LocalDate dataVencimentoAte;

    public String getDescricao() {
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimentoDe() {
        return dataVencimentoDe;
    }

    public void setDataVencimentoDe(LocalDate dataVencimentoDe) {
        this.dataVencimentoDe = dataVencimentoDe;
    }

    public LocalDate getDataVencimentoAte() {
        return dataVencimentoAte;
    }

    public void setDataVencimentoAte(LocalDate dataVencimentoAte) {
        this.dataVencimentoAte = dataVencimentoAte;
    }
}