package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTesteRepository extends JpaRepository<Item, Long> {
    List<Item> findByNomeItem(String nomeItem);
}
