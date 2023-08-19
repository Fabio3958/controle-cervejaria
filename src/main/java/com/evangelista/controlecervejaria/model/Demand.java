package com.evangelista.controlecervejaria.model;

import jakarta.persistence.*;

@Entity
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pedido_id")
    private Long id;
    @Column(name = "valor")
    private Double demandValue;

    public Demand(){}

    public Demand(Long id, Double demandValue) {
        this.id = id;
        this.demandValue = demandValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDemandValue() {
        return demandValue;
    }

    public void setDemandValue(Double demandValue) {
        this.demandValue = demandValue;
    }
}
