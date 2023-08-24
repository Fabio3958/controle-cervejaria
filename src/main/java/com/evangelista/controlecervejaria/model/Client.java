package com.evangelista.controlecervejaria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Address clientAddress;
    @OneToMany
    @JoinColumn(name = "client_id")
    private List<Demand> demandList = new ArrayList<>();



    public Client(){}

    public Client(Long id, String clientName, String clientPhoneNumber, String clientEmail, Date clientBirthday, Address clientAddress) {
        this.id = id;
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
        this.clientBirthday = clientBirthday;
        this.clientAddress = clientAddress;
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

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }
}
