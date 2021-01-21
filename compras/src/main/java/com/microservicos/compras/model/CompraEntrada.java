package com.microservicos.compras.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompraEntrada {

    @JsonProperty(value = "produto_id")
    private Integer produtoId;

    @JsonProperty(value = "cliente_id")
    private Integer clienteId;

    @JsonProperty(value = "quantidade")
    private Integer quantidade;
}
