package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Pedido;
import com.evangelista.controlecervejaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {


    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getPedidos(){
        List<Pedido> pedidoList = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") Long id){
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping("salvar")
    public ResponseEntity<Pedido> postPedidos(@RequestBody Pedido pedido){
        pedidoService.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pedido> putPedidos(@PathVariable("id") Long id, @RequestBody Pedido pedido){
        pedidoService.update(id, pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable("id") Long id){
        pedidoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
