package com.evangelista.controlecervejaria.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pedido_id")
    private Long id;
    @ManyToMany
    @Column(name = "barril_id")
    private List<Barrel> barrelList = new ArrayList<>();
    @Column(name = "valor")
    private Double demandValue;

    public Demand(){}

    public Demand(Long id, Double demandValue, List<Barrel> barrelList) {
        this.id = id;
        this.demandValue = demandValue;
        this.barrelList = barrelList;
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

    public List<Barrel> getBarrelList(){
        return barrelList;
    }

    public void setBarrelList(List<Barrel> barrelList){
        this.barrelList = barrelList;
    }
}
