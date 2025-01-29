package com.br.soluctions.attos.domus.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.soluctions.attos.domus.dtos.PersonDto;
import com.br.soluctions.attos.domus.entities.Person;

import com.br.soluctions.attos.domus.services.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> personList = new ArrayList<>();
        try {
            personList = personService.getPersons();
        } catch (Exception e) {
            System.err.println(e);
        }

        return ResponseEntity.ok(personList);

    }

    @PostMapping("new-person")
    public ResponseEntity<Void> newPerson(@RequestBody PersonDto person) {
        personService.newPerson(person);
        return ResponseEntity.ok().build();
    }

}
