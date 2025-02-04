package com.br.soluctions.attos.domus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.soluctions.attos.domus.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
