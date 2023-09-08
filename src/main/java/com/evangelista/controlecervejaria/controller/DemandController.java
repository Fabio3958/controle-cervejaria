package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Demand;
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
    public ResponseEntity<List<Demand>> getDemands(){
        List<Demand> demandList = demandService.findAll();
        return ResponseEntity.ok().body(demandList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demand> getDemandById(@PathVariable("id") Long id){
        Demand demand = demandService.findById(id);
        return ResponseEntity.ok().body(demand);
    }

    @PostMapping("salvar")
    public ResponseEntity<Demand> postDemand(@RequestBody Demand demand){
        demand.setDemandValue(demandService.calculateDemandTotalValue(demand.getBarrelList()));
        demandService.save(demand);
        return ResponseEntity.ok(demand);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Demand> putDemand(@PathVariable("id") Long id, @RequestBody Demand demand){
        demandService.update(id, demand);
        return ResponseEntity.ok(demand);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> deleteDemand(@PathVariable("id") Long id){
        demandService.delete(id);
        return ResponseEntity.ok().build();
    }

}
