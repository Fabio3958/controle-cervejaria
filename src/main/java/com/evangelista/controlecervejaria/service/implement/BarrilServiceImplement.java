package com.evangelista.controlecervejaria.service.implement;

import com.evangelista.controlecervejaria.model.Barril;
import com.evangelista.controlecervejaria.repository.BarrilRepository;
import com.evangelista.controlecervejaria.service.BarrilService;
import com.evangelista.controlecervejaria.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarrilServiceImplement implements BarrilService {

    @Autowired
    BarrilRepository barrilRepository;

    @Override
    public List<Barril> findAll() {
        return barrilRepository.findAll();
    }

    @Override
    public Barril findById(Long id) {
        Optional<Barril> barril = barrilRepository.findById(id);
        return barril.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    @Override
    public List<Barril> findByCapacidadeBarril(Double capacidade){
        return barrilRepository.findByCapacidadeBarril(capacidade);
    }

    @Override
    public void save(Barril barril) {
        barrilRepository.save(barril);
    }

    @Override
    public void update(Long id, Barril barril) {
        Optional<Barril> barrilExistente = barrilRepository.findById(id);
        if (barrilExistente.isPresent())
            barrilRepository.save(barril);
    }

    @Override
    public void delete(Long id) {
        barrilRepository.deleteById(id);
    }
}
