package com.evangelista.controlecervejaria.repository;

import com.evangelista.controlecervejaria.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
