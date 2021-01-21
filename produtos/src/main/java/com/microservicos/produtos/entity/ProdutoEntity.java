package com.microservicos.produtos.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "produto")
@Data
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "quantidade")
    private Integer quantidade;
}