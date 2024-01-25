package com.evangelista.controlecervejaria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cliente_id")
    private Long id;
    @Column(name="nome")
    @NotEmpty(message = "O campo não deve ser vazio")
    private String nomeCliente;
    @Column(name="telefone")
    @NotEmpty(message = "O campo não deve ser vazio")
    @Size(min = 11)
    private String telefoneCliente;
    @Column(name="data_de_nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimentoCliente;
    @OneToMany
    @JoinColumn(name = "client_id")
    private List<Pedido> pedidoList = new ArrayList<>();
    @Column(name = "cep")
    private String cep;
    @Column(name = "logradouro")
    private String logradouroCliente;
    @Column(name = "complemento")
    private String complementoCliente;
    @Column(name = "bairro")
    private String bairroCliente;
    @Column(name = "cidade")
    private String cidadeCliente;
}
