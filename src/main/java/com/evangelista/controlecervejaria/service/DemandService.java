package com.evangelista.controlecervejaria.service;

import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.model.Demand;

import java.util.List;

public interface DemandService {
    List<Demand> findAll();
    Demand findById(Long id);
    void save(Demand client);
    void update(Long id, Demand client);
    void delete(Long id);
    // Funcao que calcula o valor total da demanda com base no preço do litro do chopp = 12
    Double calculateDemandTotalValue(List<Barrel> barrelList);
}
