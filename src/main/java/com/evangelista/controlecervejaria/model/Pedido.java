package com.evangelista.controlecervejaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pedido_id")
    private Long id;
    @Column(name = "valor")
    private Double valorPedido;
}
