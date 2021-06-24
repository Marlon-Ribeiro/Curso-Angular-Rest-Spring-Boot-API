package com.example.algaworks.algamoney.api.resource;


import com.example.algaworks.algamoney.api.model.Categoria;
import com.example.algaworks.algamoney.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/categorias")
    public class CategoriaResource {
        @Autowired
        private CategoriaRepository categoriaRepository;

        @GetMapping
        public List<Categoria> listar(){
        return categoriaRepository.findAll();
        }

        @PostMapping
        public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
           Categoria categoriaSalva = categoriaRepository.save(categoria);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                    .buildAndExpand(categoriaSalva.getCodigo()).toUri();
            response.setHeader("Location", uri.toASCIIString());

            return ResponseEntity.created(uri).body(categoriaSalva);
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
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){
        Optional<Categoria> categoria = this.categoriaRepository.findById(codigo);
        return categoria.isPresent()?
                ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();

    }

    }




