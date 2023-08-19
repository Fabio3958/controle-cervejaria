package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
