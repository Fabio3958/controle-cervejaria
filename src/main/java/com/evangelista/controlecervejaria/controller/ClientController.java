package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Client;
import com.evangelista.controlecervejaria.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long id){
        return clientService.findById(id);
    }

    @PostMapping("/salvar")
    public void postClient(@RequestBody Client client){
        clientService.save(client);
    }

    @PutMapping("/atualizar/{id}")
    public  void putClient(@PathVariable("id") Long id, @RequestBody Client client){
        clientService.update(id, client);
    }

    @DeleteMapping("/apagar/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.delete(id);
    }
}
