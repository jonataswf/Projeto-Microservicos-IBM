package com.microservicos.produtos.validator;

import com.microservicos.produtos.exception.DadosInvalidosException;
import com.microservicos.produtos.model.ProdutoEntrada;
import org.springframework.stereotype.Component;

@Component
public class ProdutoValidator {

    public void validarId(Integer produtoId) {
        if (produtoId == null || produtoId <= 0) {
            throw new DadosInvalidosException("Id Inválido");
        }
    }

    public void validarProdutoEntrada(ProdutoEntrada produtoEntrada) {
        if (produtoEntrada.getNome() == null || produtoEntrada.getNome().isBlank()) {
            throw new DadosInvalidosException("Nome não pode ser vazio ou nulo");
        }

        if (produtoEntrada.getPreco() == null || produtoEntrada.getPreco() <= 0) {
            throw new DadosInvalidosException("Preço não pode ser nulo ou menor ou igual a 0");
        }

        if (produtoEntrada.getQuantidade() == null || produtoEntrada.getQuantidade() < 0) {
            throw new DadosInvalidosException("Quantidade não pode ser nulo ou menor ou igual a 0");
        }
    }

    public void validarQuantidade(ProdutoEntrada produtoEntrada) {
        if (produtoEntrada.getQuantidade() == null || produtoEntrada.getQuantidade() < 0) {
            throw new DadosInvalidosException("Quantidade não pode ser nulo ou menor ou igual a 0");
        }
    }
}