package com.microservicos.produtos.facade;

import com.microservicos.produtos.model.ProdutoEntrada;
import com.microservicos.produtos.model.ProdutoSaida;
import com.microservicos.produtos.service.ProdutoService;
import com.microservicos.produtos.validator.ProdutoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoFacade {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoValidator produtoValidator;

    public ProdutoSaida consultarProduto(Integer produtoId) {
        produtoValidator.validarId(produtoId);
        return produtoService.consultarProduto(produtoId);
    }

    public ProdutoSaida criarProduto(ProdutoEntrada produtoEntrada) {
        produtoValidator.validarProdutoEntrada(produtoEntrada);
        return produtoService.criarProduto(produtoEntrada);
    }

    public ProdutoSaida atualizarEstoque(Integer produtoId, ProdutoEntrada produtoEntrada) {
        produtoValidator.validarId(produtoId);
        produtoValidator.validarQuantidade(produtoEntrada);
        return produtoService.atualizarEstoque(produtoId, produtoEntrada);
    }
}
