package com.example.algaworks.algamoney.api.resource;

import com.example.algaworks.algamoney.api.model.Categoria;
import com.example.algaworks.algamoney.api.model.Pessoa;
import com.example.algaworks.algamoney.api.repository.CategoriaRepository;
import com.example.algaworks.algamoney.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
        @Autowired
        private PessoaRepository pessoaRepository;

        @GetMapping
        public List<Pessoa> listar(){
            return pessoaRepository.findAll();
        }

        @PostMapping
        public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
            Pessoa pessoaSalva = pessoaRepository.save(pessoa);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                    .buildAndExpand(pessoaSalva.getCodigo()).toUri();
            response.setHeader("Location", uri.toASCIIString());

            return ResponseEntity.created(uri).body(pessoaSalva);
        }

         /*@GetMapping("/{codigo}")
        public Categoria buscarPeloCodigo(@PathVariable Long codigo){
           return this.categoriaRepository.findById(codigo).orElse(null);
        }*/


        //Desafio : Retornar 404 caso não exista a categoria utilizando Map//
        /*@GetMapping("/{codigo}")
        public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){
            return this.categoriaRepository.findById(codigo)
                    .map(categoria -> ResponseEntity.ok(categoria))
                    .orElse(ResponseEntity.notFound().build());        }*/

        //Desafio : Retornar 404 caso não exista a categoria utilizando isPresente//
        @GetMapping("/{codigo}")
        public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo){
            Optional<Pessoa> pessoa = this.pessoaRepository.findById(codigo);
            return pessoa.isPresent()?
                    ResponseEntity.ok(pessoa.get()) : ResponseEntity.notFound().build();

        }

    }


