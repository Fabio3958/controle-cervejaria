package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Pedido;
import com.evangelista.controlecervejaria.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class DemandController {


    @Autowired
    DemandService demandService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getDemands(){
        List<Pedido> pedidoList = demandService.findAll();
        return ResponseEntity.ok().body(pedidoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getDemandById(@PathVariable("id") Long id){
        Pedido pedido = demandService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping("salvar")
    public ResponseEntity<Pedido> postDemand(@RequestBody Pedido pedido){
        pedido.setDemandValue(demandService.calculateDemandTotalValue(pedido.getBarrelList()));
        demandService.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pedido> putDemand(@PathVariable("id") Long id, @RequestBody Pedido pedido){
        demandService.update(id, pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> deleteDemand(@PathVariable("id") Long id){
        demandService.delete(id);
        return ResponseEntity.ok().build();
    }

}
