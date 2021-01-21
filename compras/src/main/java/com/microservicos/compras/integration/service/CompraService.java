package com.microservicos.compras.integration.service;

import com.microservicos.compras.entity.CompraEntity;
import com.microservicos.compras.exception.DadosInvalidosException;
import com.microservicos.compras.exception.NaoEncontradaException;
import com.microservicos.compras.integration.client.ClienteClient;
import com.microservicos.compras.integration.client.ProdutoClient;
import com.microservicos.compras.integration.model.ClienteSaida;
import com.microservicos.compras.integration.model.ProdutoEntrada;
import com.microservicos.compras.integration.model.ProdutoSaida;
import com.microservicos.compras.mapper.CompraMapper;
import com.microservicos.compras.model.CompraEntrada;
import com.microservicos.compras.model.CompraSaida;
import com.microservicos.compras.repository.CompraRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private ClienteClient client;

    @Autowired
    private ProdutoClient produto;

    @Autowired
    CompraRepository compraRepository;

    public CompraSaida comprarProduto(CompraEntrada compraEntrada) {
        try {
            ClienteSaida clienteSaida = client.obterCliente(compraEntrada.getClienteId());
        } catch (FeignException e) {
            throw new NaoEncontradaException("Id Cliente não econtrado ou Invalida na API externa");
        }

        ProdutoSaida produtoSaida = produto.consultarProduto(compraEntrada.getProdutoId());
        if (compraEntrada.getQuantidade() > produtoSaida.getQuantidade()) {
            throw new DadosInvalidosException("Quantidade do produto informada é maior que a quantidade em estoque " +
                    produtoSaida.getQuantidade());
        }

        CompraEntity compraEntity = CompraMapper.MAPPER.toEntity(compraEntrada);
        compraEntity.setValorPago(compraEntrada.getQuantidade() * produtoSaida.getPreco());

        Integer quantidade = produtoSaida.getQuantidade() - compraEntrada.getQuantidade();
        produto.atualizarEstoque(compraEntrada.getProdutoId(), new ProdutoEntrada(quantidade));

        return CompraMapper.MAPPER.toSaida(compraRepository.save(compraEntity));
    }

    public CompraSaida vizualizarCompraById(Integer compraId) {
        Optional<CompraEntity> compraEntity = compraRepository.findById(compraId);
        if (compraEntity.isPresent()) {
            CompraEntity compra = compraEntity.get();
            return CompraMapper.MAPPER.toSaida(compra);
        }
        throw new NaoEncontradaException("compra não encontrada");
    }

    public List<CompraSaida> vizualizarComprasByIdCliente(Integer clienteId) {
        List<CompraEntity> compraEntities = compraRepository.findByClienteId(clienteId);
        if (compraEntities.size() > 0) {
            return CompraMapper.MAPPER.toSaida(compraEntities);
        }
        throw new NaoEncontradaException("Nenhuma Lista de compras encontrada para este cliente");
    }

    public List<CompraSaida> vizualizarTodasCompras() {
        List<CompraEntity> compraEntities = compraRepository.findAll();
        if (compraEntities.size() > 0) {
            return CompraMapper.MAPPER.toSaida(compraEntities);
        }
        throw new NaoEncontradaException("Nenhuma Lista de compras encontrada");
    }
}
