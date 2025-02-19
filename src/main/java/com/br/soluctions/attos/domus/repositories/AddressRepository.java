package com.br.soluctions.attos.domus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.soluctions.attos.domus.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
