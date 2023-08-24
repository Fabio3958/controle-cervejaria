package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Client;
import com.evangelista.controlecervejaria.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    @PostMapping("/salvar")
    public void postClient(@RequestBody Client client){
        clientRepository.save(client);
    }

    @PutMapping("/atualizar/{id}")
    public  void putClient(@PathVariable("id") Long id, @RequestBody Client client){
        Optional<Client> existentClient = clientRepository.findById(id);
        if (existentClient.isPresent())
            clientRepository.save(client);
    }

    @DeleteMapping("/apagar/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientRepository.deleteById(id);
    }
}
