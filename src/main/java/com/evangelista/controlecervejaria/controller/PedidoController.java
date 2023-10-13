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
    public ResponseEntity<List<Pedido>> getDemands(){
        List<Pedido> pedidoList = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getDemandById(@PathVariable("id") Long id){
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping("salvar")
    public ResponseEntity<Pedido> postDemand(@RequestBody Pedido pedido){
        pedido.setValorPedido(pedidoService.calcularValorTotalDoPedido(pedido.getBarrilList()));
        pedidoService.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pedido> putDemand(@PathVariable("id") Long id, @RequestBody Pedido pedido){
        pedidoService.update(id, pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> deleteDemand(@PathVariable("id") Long id){
        pedidoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
