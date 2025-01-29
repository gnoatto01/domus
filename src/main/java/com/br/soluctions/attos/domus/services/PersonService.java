package com.br.soluctions.attos.domus.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.entities.Person;
import com.br.soluctions.attos.domus.repositories.PersonRepository;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        try {
            personList = personRepository.findAll();
        } catch (Exception e) {
            System.err.println(e);
        }
        return personList;

    }
}
