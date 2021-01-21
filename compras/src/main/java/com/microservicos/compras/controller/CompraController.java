package com.microservicos.compras.controller;

import com.microservicos.compras.facade.CompraFacade;
import com.microservicos.compras.model.CompraEntrada;
import com.microservicos.compras.model.CompraSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/compras")
public class CompraController {

    private CompraFacade compraFacade;

    @Autowired
    public CompraController(CompraFacade compraFacade) {
        this.compraFacade = compraFacade;
    }

    @PostMapping
    public CompraSaida comprarProduto(@RequestBody CompraEntrada compraEntrada) {
        return compraFacade.comprarProduto(compraEntrada);
    }

    @GetMapping("/{compraId}")
    public CompraSaida vizualizarCompraById(@PathVariable(name = "compraId") Integer compraId) {
        return compraFacade.vizualizarCompraById(compraId);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<CompraSaida> vizualizarComprasByIdCliente(@PathVariable(name = "clienteId") Integer clienteId) {
        return compraFacade.vizualizarComprasByIdCliente(clienteId);
    }

    @GetMapping
    public List<CompraSaida> vizualizarTodasCompras(){
        return compraFacade.vizualizarTodasCompras();
    }
}
