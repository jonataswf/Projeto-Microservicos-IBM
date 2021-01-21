package com.microservicos.compras.mapper;

import com.microservicos.compras.entity.CompraEntity;
import com.microservicos.compras.model.CompraEntrada;
import com.microservicos.compras.model.CompraSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CompraMapper {
    CompraMapper MAPPER = Mappers.getMapper(CompraMapper.class);

    CompraEntity toEntity(CompraEntrada compraEntrada);

    CompraSaida toSaida(CompraEntity compraEntity);

    List<CompraSaida> toSaida(List<CompraEntity> compraEntities);
}
