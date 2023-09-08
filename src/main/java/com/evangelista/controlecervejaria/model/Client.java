package com.evangelista.controlecervejaria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cliente_id")
    private Long id;
    @Column(name="nome")
    private String clientName;
    @Column(name="telefone")
    private String clientPhoneNumber;
    @Column(name="email")
    private String clientEmail;
    @Column(name="data_de_nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date clientBirthday;
    @Column(name="cidade")
    private String clientCity;
    @Column(name="bairro")
    private String clientDistrict;
    @Column(name="rua")
    private String clientStreet;
    @Column(name="numero_casa")
    private String clientAddressNumber;
    @OneToMany
    @JoinColumn(name = "client_id")
    private List<Demand> demandList = new ArrayList<>();



    public Client(){}

    public Client(Long id, String clientName, String clientPhoneNumber, String clientEmail, Date clientBirthday,
                  String clientCity, String clientDistrict, String clientStreet,
                  String clientAddressNumber, List<Demand> demandList) {
        this.id = id;
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
        this.clientBirthday = clientBirthday;
        this.clientCity = clientCity;
        this.clientDistrict = clientDistrict;
        this.clientStreet = clientStreet;
        this.clientAddressNumber = clientAddressNumber;
        this.demandList = demandList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Date getClientBirthday() {
        return clientBirthday;
    }

    public void setClientBirthday(Date clientBirthday) {
        this.clientBirthday = clientBirthday;
    }

    public List<Demand> getDemandList() {
        return demandList;
    }

    public void setDemandList(List<Demand> demandList) {
        this.demandList = demandList;
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
