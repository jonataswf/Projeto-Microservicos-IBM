package com.microservicos.compras.integration.client;

import com.microservicos.compras.integration.model.ProdutoEntrada;
import com.microservicos.compras.integration.model.ProdutoSaida;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "produtoClient", url = "${rota.produtos}")
public interface ProdutoClient {

    @PutMapping("/{produtoId}")
    ProdutoSaida atualizarEstoque(@PathVariable(name = "produtoId") Integer produtoId,
                                  @RequestBody ProdutoEntrada produtoEntrada);

    @GetMapping("/{produtoId}")
    ProdutoSaida consultarProduto(@PathVariable(name = "produtoId") Integer id);

}
