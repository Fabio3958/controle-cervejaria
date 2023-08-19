package com.evangelista.controlecervejaria.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
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
    private Date clientBirthday;
    @Embedded
    private Address clientAddress;
    @OneToMany
    @JoinColumn(name = "client_id")
    private List<Demand> demandList = new ArrayList<>();

    public Client(){}

    public Client(Long id, String clientName, String clientPhoneNumber, String clientEmail, Date clientBirthday) {
        this.id = id;
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
        this.clientBirthday = clientBirthday;
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

    public List<Demand> getOrderList() {
        return demandList;
    }

    public void setOrderList(List<Demand> demandList) {
        this.demandList = demandList;
    }
}
