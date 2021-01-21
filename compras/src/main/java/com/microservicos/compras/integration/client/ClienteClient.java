package com.microservicos.compras.integration.client;

import com.microservicos.compras.integration.model.ClienteSaida;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarioClient", url = "${rota.api}")
public interface ClienteClient {

    @GetMapping("/{id}")
    ClienteSaida obterCliente(@PathVariable(name = "id") Integer id);

}
