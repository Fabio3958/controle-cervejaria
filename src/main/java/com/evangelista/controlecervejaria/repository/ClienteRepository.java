package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeCliente(String nome);
}
