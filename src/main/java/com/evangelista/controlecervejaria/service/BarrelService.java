package com.evangelista.controlecervejaria.service;

import com.evangelista.controlecervejaria.model.Barrel;

import java.util.List;

public interface BarrelService {
    List<Barrel> findAll();
    Barrel findById(Long id);
    void save(Barrel barrel);
    void update(Long id, Barrel barrel);
    void delete(Long id);
}
