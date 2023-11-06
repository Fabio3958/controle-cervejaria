package com.evangelista.controlecervejaria.service;

import com.evangelista.controlecervejaria.model.Barril;

import java.util.List;

public interface BarrilService {
    List<Barril> findAll();
    Barril findById(Long id);
    List<Barril> findByCapacidadeBarril(Double capacidade);
    void save(Barril barril);
    void update(Long id, Barril barril);
    void delete(Long id);
}
