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
import java.net.URI;
import java.util.List;

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
        //@ResponseStatus(HttpStatus.CREATED) // vai me reronar um 201 created
        public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response) {
        // @@RequestBody pode ser colocada em um metodo no nosso caso é o "crar"
        // @@RequestBody --> se corpo da requisição que enviamos dados para serem gravados no servido
           Categoria categoriaSalva = categoriaRepository.save(categoria);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                    .buildAndExpand(categoriaSalva.getCodigo()).toUri();
            response.setHeader("Location", uri.toASCIIString());
           //no REST Devemos informar como  recuperar o recurso que foi criado

            return ResponseEntity.created(uri).body(categoriaSalva);
        }

    @GetMapping("/{codigo}")
    public Categoria buscarPeloCodigo(@PathVariable long codigo){
           return this.categoriaRepository.findById(codigo).orElse(null);
        }

    }




