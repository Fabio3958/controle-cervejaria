package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Cliente;
import com.evangelista.controlecervejaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClients(){
        List<Cliente> clienteList = clienteService.findAll();
        return ResponseEntity.ok().body(clienteList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientById(@PathVariable("id") Long id){
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Cliente> postClient(@RequestBody Cliente cliente){
        clienteService.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping(value = "/atualizar/{id}")
    public  ResponseEntity<Cliente> putClient(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        clienteService.update(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping(value = "/apagar/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id){
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
