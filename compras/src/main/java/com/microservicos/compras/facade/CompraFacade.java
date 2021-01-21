package com.microservicos.compras.facade;

import com.microservicos.compras.integration.service.CompraService;
import com.microservicos.compras.model.CompraEntrada;
import com.microservicos.compras.model.CompraSaida;
import com.microservicos.compras.validator.CompraValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraFacade {

    private CompraService compraService;

    @Autowired
    public CompraFacade(CompraService compraService) {
        this.compraService = compraService;
    }

    @Autowired
    CompraValidator compraValidator;

    public CompraSaida comprarProduto(CompraEntrada compraEntrada) {
        compraValidator.validarCompraEntrada(compraEntrada);
        return compraService.comprarProduto(compraEntrada);
    }

    public CompraSaida vizualizarCompraById(Integer compraId) {
        compraValidator.validarId(compraId);
        return compraService.vizualizarCompraById(compraId);
    }

    public List<CompraSaida> vizualizarComprasByIdCliente(Integer clienteId) {
        compraValidator.validarId(clienteId);
        return compraService.vizualizarComprasByIdCliente(clienteId);
    }

    public List<CompraSaida> vizualizarTodasCompras() {
        return compraService.vizualizarTodasCompras();
    }
}
