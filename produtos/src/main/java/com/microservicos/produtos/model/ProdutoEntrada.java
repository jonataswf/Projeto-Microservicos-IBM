package com.microservicos.produtos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoEntrada {

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "preco")
    private Double preco;

    @JsonProperty(value = "quantidade")
    private Integer quantidade;
}