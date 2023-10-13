package com.evangelista.controlecervejaria.service.implement;

import com.evangelista.controlecervejaria.model.Barril;
import com.evangelista.controlecervejaria.model.Pedido;
import com.evangelista.controlecervejaria.repository.PedidoRepository;
import com.evangelista.controlecervejaria.service.PedidoService;
import com.evangelista.controlecervejaria.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImplement implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;


    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        Optional<Pedido> demand = pedidoRepository.findById(id);
        return demand.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    @Override
    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void update(Long id, Pedido pedido) {
        Optional<Pedido> existentDemand = pedidoRepository.findById(id);
        if (existentDemand.isPresent())
            pedidoRepository.save(pedido);
    }

    @Override
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Double calcularValorTotalDoPedido(List<Barril> barrilList){
        List<Double> barrelValues = new ArrayList<>();
        for (Barril barril : barrilList) {
            barrelValues.add((barril.getCapacidadeBarril()) * 12);
        }
        return barrelValues.stream().mapToDouble(Double::doubleValue).sum();
    }
}
