package com.microservicos.compras.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "compra")
@Data
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "produto_id")
    private Integer produtoId;

    @Column(name = "cliente_id")
    private Integer clienteId;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor_produto")
    private Double valorPago;
}
