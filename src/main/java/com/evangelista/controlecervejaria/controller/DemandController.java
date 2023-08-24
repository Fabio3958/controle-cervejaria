package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Demand;
import com.evangelista.controlecervejaria.repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class DemandController {

    @Autowired
    DemandRepository demandRepository;

    @GetMapping
    public List<Demand> getDemands(){
        return demandRepository.findAll();
    }

    @GetMapping("/{id}")
    public Demand getDemandById(@PathVariable("id") Long id){
        Optional<Demand> demand = demandRepository.findById(id);
        return demand.orElse(null);
    }

    @PostMapping("salvar")
    public void postDemand(@RequestBody Demand demand){
        demandRepository.save(demand);
    }

    @PutMapping("/atualizar/{id}")
    public void putDemand(@PathVariable("id") Long id, @RequestBody Demand demand){
        Optional<Demand> existentDemand = demandRepository.findById(id);
        if (existentDemand.isPresent())
            demandRepository.save(demand);
    }

    @DeleteMapping("/apagar/{id}")
    public void deleteDemand(@PathVariable("id") Long id){
        demandRepository.deleteById(id);
    }

}
