package com.evangelista.controlecervejaria.service.implement;

import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.model.Pedido;
import com.evangelista.controlecervejaria.repository.PedidoRepository;
import com.evangelista.controlecervejaria.service.DemandService;
import com.evangelista.controlecervejaria.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImplement implements DemandService {

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
    public Double calculateDemandTotalValue(List<Barrel> barrelList){
        List<Double> barrelValues = new ArrayList<>();
        for (Barrel barrel : barrelList) {
            barrelValues.add((barrel.getBarrelVolume()) * 12);
        }
        return barrelValues.stream().mapToDouble(Double::doubleValue).sum();
    }
}
