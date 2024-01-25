package com.evangelista.controlecervejaria.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;
    @Column(name = "nome_item")
    private String nomeItem;
    @Column(name = "valor_item")
    private Double valorItem;
}
