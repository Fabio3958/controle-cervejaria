package com.evangelista.controlecervejaria.service;

import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.model.Pedido;

import java.util.List;

public interface DemandService {
    List<Pedido> findAll();
    Pedido findById(Long id);
    void save(Pedido client);
    void update(Long id, Pedido client);
    void delete(Long id);
    // Funcao que calcula o valor total da demanda com base no preço do litro do chopp = 12
    Double calculateDemandTotalValue(List<Barrel> barrelList);
}
