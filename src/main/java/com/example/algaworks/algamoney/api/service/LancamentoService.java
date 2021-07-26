package com.example.algaworks.algamoney.api.service;

import com.example.algaworks.algamoney.api.model.Lancamento;
import com.example.algaworks.algamoney.api.model.Pessoa;
import com.example.algaworks.algamoney.api.repository.LancamentoRepository;
import com.example.algaworks.algamoney.api.repository.PessoaRepository;
import com.example.algaworks.algamoney.api.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento)  {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if (!pessoaOptional.isPresent() || pessoaOptional.get().isInativa()) {
         throw new PessoaInexistenteOuInativaException();
        }
         return lancamentoRepository.save(lancamento);
    }
}
