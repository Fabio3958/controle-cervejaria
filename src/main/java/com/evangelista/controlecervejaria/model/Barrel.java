package com.evangelista.controlecervejaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "barril")
public class Barrel {
    @Id
    @Column(name="barril_id")
    private Long id;
    @Column(name="capacidade")
    @NotNull
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
