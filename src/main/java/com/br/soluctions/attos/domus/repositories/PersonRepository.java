package com.br.soluctions.attos.domus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.soluctions.attos.domus.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
