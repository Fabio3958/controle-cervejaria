package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.service.BarrelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barris")
public class BarrelController {

    @Autowired
    BarrelService barrelService;

    @GetMapping
    public List<Barrel> getBarrels(){
        return barrelService.findAll();
    }

    @GetMapping("/{id}")
    public Barrel getBarrelById(@PathVariable("id") Long id){
        return barrelService.findById(id);
    }

    @PostMapping("/salvar")
    public void postBarrel(@RequestBody Barrel barrel){
        barrelService.save(barrel);
    }

    @PutMapping("/atualizar/{id}")
    public void putBarrel(@RequestBody Barrel barrel, @PathVariable("id") Long id){
        barrelService.update(id, barrel);
    }

    @DeleteMapping("apagar/{id}")
    public void deleteBarrel(@PathVariable("id") Long id){
        barrelService.delete(id);
    }

}
