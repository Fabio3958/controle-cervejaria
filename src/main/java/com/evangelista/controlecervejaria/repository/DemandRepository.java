package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, Long> {
}
