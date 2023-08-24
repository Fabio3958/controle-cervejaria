package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.repository.BarrelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/barris")
public class BarrelController {

    @Autowired
    BarrelRepository barrelRepository;

    @GetMapping
    public List<Barrel> getBarrels(){
        return barrelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Barrel getBarrelById(@PathVariable("id") Long id){
        Optional<Barrel> barrel = barrelRepository.findById(id);
        return barrel.orElse(null);
    }

    @PostMapping("/salvar")
    public void postBarrel(@RequestBody Barrel barrel){
        barrelRepository.save(barrel);
    }

    @PutMapping("/atualizar/{id}")
    public void putBarrel(@RequestBody Barrel barrel, @PathVariable("id") Long id){
        Optional<Barrel> existentBarrel = barrelRepository.findById(id);
        if (existentBarrel.isPresent())
            barrelRepository.save(barrel);
    }

    @DeleteMapping("apagar/{id}")
    public void deleteBarrel(@PathVariable("id") Long id){
        barrelRepository.deleteById(id);
    }

}
