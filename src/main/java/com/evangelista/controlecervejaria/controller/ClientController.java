package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Client;
import com.evangelista.controlecervejaria.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clientList = clientService.findAll();
        return ResponseEntity.ok().body(clientList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
        Client client = clientService.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Client> postClient(@RequestBody Client client){
        clientService.save(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/atualizar/{id}")
    public  ResponseEntity<Client> putClient(@PathVariable("id") Long id, @RequestBody Client client){
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id){
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
