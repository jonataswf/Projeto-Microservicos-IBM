package com.microservicos.compras.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoEntrada {

    @JsonProperty(value = "quantidade")
    private Integer quantidade;

    public ProdutoEntrada(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
