package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Item;
import com.evangelista.controlecervejaria.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "itens")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    ResponseEntity<List<Item>> getItens(){
        List<Item> itemList = itemService.findAll();
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<Item> getItemById(@PathVariable("id") Long id){
        Item item = itemService.findById(id);
        return ResponseEntity.ok().body(item);
    }

    @GetMapping("/nome/{nomeItem}")
    ResponseEntity<List<Item>> getItemByNome(@PathVariable("nomeItem") String nome){
        List<Item> itemList = itemService.findByNomeItem(nome);
        return ResponseEntity.ok().body(itemList);
    }

    @PostMapping("/salvar")
    ResponseEntity<Item> postItem(@RequestBody Item item){
        itemService.save(item);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/atualizar/{id}")
    ResponseEntity<Item> putItem(@PathVariable("id") Long id, @RequestBody Item item){
        itemService.update(id, item);
        return ResponseEntity.ok().body(item);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteItem(@PathVariable("id") Long id){
        itemService.delete(id);
        return ResponseEntity.ok().build();
    }
}
