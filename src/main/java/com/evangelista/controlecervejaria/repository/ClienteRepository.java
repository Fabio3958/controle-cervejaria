package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
