package com.microservicos.produtos.controller;

import com.microservicos.produtos.facade.ProdutoFacade;
import com.microservicos.produtos.model.ProdutoEntrada;
import com.microservicos.produtos.model.ProdutoSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoFacade produtoFacade;

    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoSaida> consultarProduto(@PathVariable(name = "produtoId") Integer produtoId) {
        return ResponseEntity.ok().body(produtoFacade.consultarProduto(produtoId));
    }

    @PostMapping()
    public ResponseEntity<ProdutoSaida> criarProduto(@RequestBody ProdutoEntrada produtoEntrada) {
        ProdutoSaida produtoSaida = produtoFacade.criarProduto(produtoEntrada);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(produtoSaida.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoSaida);
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<ProdutoSaida> atualizarEstoque(@PathVariable(name = "produtoId") Integer produtoId,
                                                         @RequestBody ProdutoEntrada produtoEntrada) {
        return ResponseEntity.accepted().body(produtoFacade.atualizarEstoque(produtoId, produtoEntrada));
    }
}