package com.evangelista.controlecervejaria.service.implement;

import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.repository.BarrelRepository;
import com.evangelista.controlecervejaria.service.BarrelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarrelServiceImplement implements BarrelService {

    @Autowired
    BarrelRepository barrelRepository;

    @Override
    public List<Barrel> findAll() {
        return barrelRepository.findAll();
    }

    @Override
    public Barrel findById(Long id) {
        Optional<Barrel> barrel = barrelRepository.findById(id);
        return barrel.orElse(null);
    }

    @Override
    public void save(Barrel barrel) {
        barrelRepository.save(barrel);
    }

    @Override
    public void update(Long id, Barrel barrel) {
        Optional<Barrel> existentBarrel = barrelRepository.findById(id);
        if (existentBarrel.isPresent())
            barrelRepository.save(barrel);
    }

    @Override
    public void delete(Long id) {
        barrelRepository.deleteById(id);
    }
}
