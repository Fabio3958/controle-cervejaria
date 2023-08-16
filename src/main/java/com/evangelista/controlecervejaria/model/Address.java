package com.evangelista.controlecervejaria.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String clientState;
    private String clientCity;
    private String clientDistrict;
    private String clientStreet;
    private String clientAddressNumber;

    public Address(){}

    public Address(String clientState, String clientCity, String clientDistrict, String clientStreet, String clientAddressNumber) {
        this.clientState = clientState;
        this.clientCity = clientCity;
        this.clientDistrict = clientDistrict;
        this.clientStreet = clientStreet;
        this.clientAddressNumber = clientAddressNumber;
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
}