package com.br.soluctions.attos.domus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.soluctions.attos.domus.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = " select * from tb_person p where p.is_active = 'S' ", nativeQuery = true)
    List<Person> findActivePersons();
}
