package com.evangelista.controlecervejaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "barril")
public class Barrel {
    @Id
    @Column(name="barril_id")
    private Long id;
    @Column(name="capacidade")
    @NotNull
    private Double barrelVolume;
}
