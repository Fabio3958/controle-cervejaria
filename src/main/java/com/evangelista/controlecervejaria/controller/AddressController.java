package com.evangelista.controlecervejaria.controller;

import com.evangelista.controlecervejaria.model.Address;
import com.evangelista.controlecervejaria.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//TODO ARRUMAR OS CAMPOS QUE NÃO ESTÃO RECEBENDO DADOS E LINKAR COM OS CLIENTES
@RestController
@RequestMapping("/enderecos")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") Long id){
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }

    @PostMapping("salvar")
    public void postAddress(@RequestBody Address address){
        addressRepository.save(address);
    }

    @PutMapping("atualizar/{id}")
    public void updateAddress(@RequestBody Address address, @PathVariable("id") Long id){
        Optional<Address> existentAddress = addressRepository.findById(id);
        if (existentAddress.isPresent())
            addressRepository.save(address);
    }

    @DeleteMapping("apagar/{id}")
    public void deleteAddress(@PathVariable("id") Long id){
        addressRepository.deleteById(id);
    }
}
