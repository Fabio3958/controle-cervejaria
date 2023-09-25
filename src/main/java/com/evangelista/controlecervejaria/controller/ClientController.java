package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Client;
import com.evangelista.controlecervejaria.service.ClientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
@Tag(name = "open-api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Dados não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clientList = clientService.findAll();
        return ResponseEntity.ok().body(clientList);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Dados não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
        Client client = clientService.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Dados não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @PostMapping(value = "/salvar")
    public ResponseEntity<Client> postClient(@RequestBody Client client){
        clientService.save(client);
        return ResponseEntity.ok(client);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Dados não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @PutMapping(value = "/atualizar/{id}")
    public  ResponseEntity<Client> putClient(@PathVariable("id") Long id, @RequestBody Client client){
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Dados não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @DeleteMapping(value = "/apagar/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id){
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
