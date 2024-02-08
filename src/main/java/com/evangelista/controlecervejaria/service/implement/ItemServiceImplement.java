package com.evangelista.controlecervejaria.service.implement;

import com.evangelista.controlecervejaria.model.Item;
import com.evangelista.controlecervejaria.repository.ItemRepository;
import com.evangelista.controlecervejaria.service.ItemService;
import com.evangelista.controlecervejaria.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ItemServiceImplement implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    @Override
    public List<Item> findByNomeItem(String nomeItem) {
        return itemRepository.findByNomeItem(nomeItem);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void update(Long id, Item item) {
        Optional<Item> existentItem = itemRepository.findById(id);
        if (existentItem.isPresent())
            itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
