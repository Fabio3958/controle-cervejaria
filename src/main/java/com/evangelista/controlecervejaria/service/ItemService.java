package com.evangelista.controlecervejaria.service;

import com.evangelista.controlecervejaria.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();
    Item findById(Long id);
    List<Item> findByNomeItem(String nomeItem);
    void save(Item item);
    void update(Long id, Item item);
    void delete(Long id);
}
