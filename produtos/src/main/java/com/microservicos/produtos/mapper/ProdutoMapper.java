package com.microservicos.produtos.mapper;

import com.microservicos.produtos.entity.ProdutoEntity;
import com.microservicos.produtos.model.ProdutoEntrada;
import com.microservicos.produtos.model.ProdutoSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {
    ProdutoMapper MAPPER = Mappers.getMapper(ProdutoMapper.class);

    ProdutoEntity toEntity(ProdutoEntrada produtoEntrada);

    ProdutoSaida toSaida(ProdutoEntity produtoEntity);
}
