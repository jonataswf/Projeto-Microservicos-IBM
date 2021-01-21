package com.microservicos.produtos.service;

import com.microservicos.produtos.entity.ProdutoEntity;
import com.microservicos.produtos.exception.ProdutoNaoEncontradoException;
import com.microservicos.produtos.mapper.ProdutoMapper;
import com.microservicos.produtos.model.ProdutoEntrada;
import com.microservicos.produtos.model.ProdutoSaida;
import com.microservicos.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoSaida consultarProduto(Integer produtoId) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(produtoId);
        if (produtoEntity.isPresent()) {
            ProdutoEntity produto = produtoEntity.get();
            return ProdutoMapper.MAPPER.toSaida(produto);
        }
        throw new ProdutoNaoEncontradoException("Produto não encontrado");
    }

    public ProdutoSaida criarProduto(ProdutoEntrada produtoEntrada) {
        ProdutoEntity produtoEntity = ProdutoMapper.MAPPER.toEntity(produtoEntrada);
        return ProdutoMapper.MAPPER.toSaida(produtoRepository.save(produtoEntity));
    }

    public ProdutoSaida atualizarEstoque(Integer produtoId, ProdutoEntrada produtoEntrada) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(produtoId);
        if (produtoEntity.isPresent()) {
            ProdutoEntity produto = produtoEntity.get();
            produto.setQuantidade(produtoEntrada.getQuantidade());
            return ProdutoMapper.MAPPER.toSaida(produtoRepository.save(produto));
        }
        throw new ProdutoNaoEncontradoException("Produto não encontrado");
    }
}