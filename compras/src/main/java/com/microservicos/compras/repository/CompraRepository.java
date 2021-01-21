package com.microservicos.compras.repository;

import com.microservicos.compras.entity.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Integer> {
    List<CompraEntity> findByClienteId(Integer clienteId);
}
