package com.evangelista.controlecervejaria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Address {

    @Id
    @Column(name = "endereco_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="estado")
    private String clientState;
    @Column(name="cidade")
    private String clientCity;
    @Column(name="bairro")
    private String clientDistrict;
    @Column(name="rua")
    private String clientStreet;
    @Column(name="numero_casa")
    private String clientAddressNumber;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "clientAddress")
    private Client owner;

    public Address(){}

    public Address(Long id, String clientState, String clientCity, String clientDistrict, String clientStreet, String clientAddressNumber, Client owner) {
        this.id = id;
        this.clientState = clientState;
        this.clientCity = clientCity;
        this.clientDistrict = clientDistrict;
        this.clientStreet = clientStreet;
        this.clientAddressNumber = clientAddressNumber;
        this.owner = owner;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getClientState() {
        return clientState;
    }

    public void setClientState(String clientState) {
        this.clientState = clientState;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientDistrict() {
        return clientDistrict;
    }

    public void setClientDistrict(String clientDistrict) {
        this.clientDistrict = clientDistrict;
    }

    public String getClientStreet() {
        return clientStreet;
    }

    public void setClientStreet(String clientStreet) {
        this.clientStreet = clientStreet;
    }

    public String getClientAddressNumber() {
        return clientAddressNumber;
    }

    public void setClientAddressNumber(String clientAddressNumber) {
        this.clientAddressNumber = clientAddressNumber;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}
