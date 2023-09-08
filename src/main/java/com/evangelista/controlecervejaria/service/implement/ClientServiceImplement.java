package com.evangelista.controlecervejaria.service.implement;

import com.evangelista.controlecervejaria.model.Client;
import com.evangelista.controlecervejaria.repository.ClientRepository;
import com.evangelista.controlecervejaria.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImplement implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> existentClient = clientRepository.findById(id);
        if (existentClient.isPresent())
            clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
