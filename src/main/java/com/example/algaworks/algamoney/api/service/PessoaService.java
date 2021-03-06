package com.example.algaworks.algamoney.api.service;

import com.example.algaworks.algamoney.api.model.Pessoa;
import com.example.algaworks.algamoney.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

    @Service
    public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa atualizar(@PathVariable Long codigo, @RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);

        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");

        return this.pessoaRepository.save(pessoaSalva);
    }



    public void  atualizarPropriedadeAtivo(Long codigo,Boolean ativo){
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
        }

    public Pessoa buscarPessoaPeloCodigo(Long codigo) {
        Pessoa pessoaSalva = this.pessoaRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return pessoaSalva;
    }
}
