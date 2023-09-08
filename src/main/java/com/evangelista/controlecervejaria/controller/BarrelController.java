package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.service.BarrelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barris")
public class BarrelController {

    @Autowired
    BarrelService barrelService;

    @GetMapping
    public ResponseEntity<List<Barrel>> getBarrels(){
        List<Barrel> barrelList = barrelService.findAll();
        return ResponseEntity.ok().body(barrelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barrel> getBarrelById(@PathVariable("id") Long id){
        Barrel barrel = barrelService.findById(id);
        return ResponseEntity.ok().body(barrel);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Barrel> postBarrel(@RequestBody Barrel barrel){
        barrelService.save(barrel);
        return ResponseEntity.ok().body(barrel);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Barrel> putBarrel(@RequestBody Barrel barrel, @PathVariable("id") Long id){
        barrelService.update(id, barrel);
        return ResponseEntity.ok().body(barrel);
    }

    @DeleteMapping("apagar/{id}")
    public ResponseEntity<Void> deleteBarrel(@PathVariable("id") Long id){
        barrelService.delete(id);
        return ResponseEntity.ok().build();
    }

}
