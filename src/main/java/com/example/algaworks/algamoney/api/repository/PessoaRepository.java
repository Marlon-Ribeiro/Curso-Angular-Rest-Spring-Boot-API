package com.example.algaworks.algamoney.api.repository;
import com.example.algaworks.algamoney.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
