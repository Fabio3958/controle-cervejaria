package com.evangelista.controlecervejaria.service;

import com.evangelista.controlecervejaria.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    void save(Cliente cliente);
    void update(Long id, Cliente cliente);
    void delete(Long id);
}
