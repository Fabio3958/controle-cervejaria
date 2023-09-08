package com.evangelista.controlecervejaria.service;

import com.evangelista.controlecervejaria.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();
    Client findById(Long id);
    void save(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
