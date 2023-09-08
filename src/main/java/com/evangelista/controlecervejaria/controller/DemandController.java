package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Demand;
import com.evangelista.controlecervejaria.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class DemandController {


    @Autowired
    DemandService demandService;

    @GetMapping
    public List<Demand> getDemands(){
        return demandService.findAll();
    }

    @GetMapping("/{id}")
    public Demand getDemandById(@PathVariable("id") Long id){
        return demandService.findById(id);
    }

    @PostMapping("salvar")
    public void postDemand(@RequestBody Demand demand){
        demand.setDemandValue(demandService.calculateDemandTotalValue(demand.getBarrelList()));
        demandService.save(demand);
    }

    @PutMapping("/atualizar/{id}")
    public void putDemand(@PathVariable("id") Long id, @RequestBody Demand demand){
        demandService.update(id, demand);
    }

    @DeleteMapping("/apagar/{id}")
    public void deleteDemand(@PathVariable("id") Long id){
        demandService.delete(id);
    }

}
