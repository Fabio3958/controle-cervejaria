package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Barril;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarrilRepository extends JpaRepository<Barril, Long> {
}
