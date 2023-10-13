package com.evangelista.controlecervejaria.service;

import com.evangelista.controlecervejaria.model.Barril;
import com.evangelista.controlecervejaria.model.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> findAll();
    Pedido findById(Long id);
    void save(Pedido client);
    void update(Long id, Pedido client);
    void delete(Long id);
    // Funcao que calcula o valor total da demanda com base no preço do litro do chopp = 12
    Double calcularValorTotalDoPedido(List<Barril> barrilList);
}
