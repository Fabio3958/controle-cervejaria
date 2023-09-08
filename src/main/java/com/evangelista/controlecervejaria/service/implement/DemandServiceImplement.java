package com.evangelista.controlecervejaria.service.implement;

import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.model.Client;
import com.evangelista.controlecervejaria.model.Demand;
import com.evangelista.controlecervejaria.repository.DemandRepository;
import com.evangelista.controlecervejaria.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemandServiceImplement implements DemandService {

    @Autowired
    DemandRepository demandRepository;


    @Override
    public List<Demand> findAll() {
        return demandRepository.findAll();
    }

    @Override
    public Demand findById(Long id) {
        Optional<Demand> demand = demandRepository.findById(id);
        return demand.orElse(null);
    }

    @Override
    public void save(Demand demand) {
        demandRepository.save(demand);
    }

    @Override
    public void update(Long id, Demand demand) {
        Optional<Demand> existentDemand = demandRepository.findById(id);
        if (existentDemand.isPresent())
            demandRepository.save(demand);
    }

    @Override
    public void delete(Long id) {
        demandRepository.deleteById(id);
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
