package com.evangelista.controlecervejaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Barrel {
    @Id
    @Column(name="barril_id")
    private Long id;
    @Column(name="capacidade")
    private Double barrelVolume;

    public Barrel(){}

    public Barrel(Long id, Double barrelVolume) {
        this.id = id;
        this.barrelVolume = barrelVolume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBarrelVolume() {
        return barrelVolume;
    }

    public void setBarrelVolume(Double barrelVolume) {
        this.barrelVolume = barrelVolume;
    }
}
