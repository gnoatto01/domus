package com.br.soluctions.attos.domus.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.dtos.PersonDto;
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

    public void newPerson(PersonDto person) {
        try {
            var newPerson = new Person();

            newPerson.setName(person.name());
            newPerson.setLastName(person.lastName());
            newPerson.setPhone(person.phone());
            newPerson.setCellPhone(person.cellPhone());
            newPerson.setEmail(person.email());

            personRepository.save(newPerson);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
