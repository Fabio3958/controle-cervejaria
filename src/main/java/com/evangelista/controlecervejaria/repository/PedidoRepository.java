package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
