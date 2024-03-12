package com.evangelista.controlecervejaria.service;
import com.evangelista.controlecervejaria.model.Pedido;
import java.util.List;

public interface PedidoService {
    List<Pedido> findAll();
    Pedido findById(Long id);
    void save(Pedido client);
    void update(Long id, Pedido client);
    void delete(Long id);
}
