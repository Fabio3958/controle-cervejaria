package com.evangelista.controlecervejaria.service.implement;

import com.evangelista.controlecervejaria.model.Item;
import com.evangelista.controlecervejaria.repository.ItemTesteRepository;
import com.evangelista.controlecervejaria.service.ItemService;
import com.evangelista.controlecervejaria.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImplement implements ItemService {

    @Autowired
    ItemTesteRepository itemTesteRepository;

    @Override
    public List<Item> findAll() {
        return itemTesteRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        Optional<Item> item = itemTesteRepository.findById(id);
        return item.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    @Override
    public List<Item> findByNomeItem(String nomeItem) {
        return itemTesteRepository.findByNomeItem(nomeItem);
    }

    @Override
    public void save(Item item) {
        itemTesteRepository.save(item);
    }

    @Override
    public void update(Long id, Item item) {
        Optional<Item> existentItem = itemTesteRepository.findById(id);
        if (existentItem.isPresent())
            itemTesteRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        itemTesteRepository.deleteById(id);
    }
}
