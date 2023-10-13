package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Barril;
import com.evangelista.controlecervejaria.service.BarrilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barris")
public class BarrelController {

    @Autowired
    BarrilService barrilService;

    @GetMapping
    public ResponseEntity<List<Barril>> getBarris(){
        List<Barril> barrilList = barrilService.findAll();
        return ResponseEntity.ok().body(barrilList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barril> getBarrilById(@PathVariable("id") Long id){
        Barril barril = barrilService.findById(id);
        return ResponseEntity.ok().body(barril);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Barril> postBarril(@RequestBody Barril barril){
        barrilService.save(barril);
        return ResponseEntity.ok().body(barril);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Barril> putBarril(@RequestBody Barril barril, @PathVariable("id") Long id){
        barrilService.update(id, barril);
        return ResponseEntity.ok().body(barril);
    }

    @DeleteMapping("apagar/{id}")
    public ResponseEntity<Void> deleteBarril(@PathVariable("id") Long id){
        barrilService.delete(id);
        return ResponseEntity.ok().build();
    }

}
