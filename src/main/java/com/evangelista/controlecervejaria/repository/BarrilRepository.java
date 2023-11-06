package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Barril;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarrilRepository extends JpaRepository<Barril, Long> {
    List<Barril> findByCapacidadeBarril(Double capacidade);
}
