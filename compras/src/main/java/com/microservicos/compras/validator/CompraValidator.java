package com.microservicos.compras.validator;


import com.microservicos.compras.exception.DadosInvalidosException;
import com.microservicos.compras.model.CompraEntrada;
import org.springframework.stereotype.Component;

@Component
public class CompraValidator {

    public void validarId(Integer id) {
        if (id == null || id <= 0) {
            throw new DadosInvalidosException("Id Inválido");
        }
    }

    public void validarCompraEntrada(CompraEntrada compraEntrada) {

        if (compraEntrada.getClienteId() == null || compraEntrada.getClienteId() <= 0) {
            throw new DadosInvalidosException("Id Cliente Inválido");
        }

        if (compraEntrada.getProdutoId() == null || compraEntrada.getProdutoId() <= 0) {
            throw new DadosInvalidosException("Id Produto Inválido");
        }

        if (compraEntrada.getQuantidade() == null || compraEntrada.getQuantidade() < 0) {
            throw new DadosInvalidosException("Quantidade não pode ser nulo ou menor ou igual a 0");
        }
    }
}