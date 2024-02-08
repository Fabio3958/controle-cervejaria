package com.evangelista.controlecervejaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pedido_id")
    private Long id;
    @Column(name = "lista_itens")
    @ManyToMany
    private List<Item> itemList;
    @Column(name = "valor")
    private Double valorPedido;
}
