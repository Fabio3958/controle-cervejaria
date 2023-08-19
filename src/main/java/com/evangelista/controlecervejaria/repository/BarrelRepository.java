package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Barrel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarrelRepository extends JpaRepository<Barrel, Long> {
}
