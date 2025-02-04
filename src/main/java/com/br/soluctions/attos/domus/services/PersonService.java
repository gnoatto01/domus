package com.br.soluctions.attos.domus.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.dtos.PersonDto;
import com.br.soluctions.attos.domus.entities.Address;
import com.br.soluctions.attos.domus.entities.NaturalPerson;
import com.br.soluctions.attos.domus.entities.Person;
import com.br.soluctions.attos.domus.repositories.AddressRepository;
import com.br.soluctions.attos.domus.repositories.NaturalPersonRepository;
import com.br.soluctions.attos.domus.repositories.PersonRepository;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private NaturalPersonRepository naturalPersonRepository;
    private AddressRepository addressRepository;

    public PersonService(PersonRepository personRepository, NaturalPersonRepository naturalPersonRepository,
            AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.naturalPersonRepository = naturalPersonRepository;
        this.addressRepository = addressRepository;
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

            // pessoa base

            var newPerson = new Person();

            newPerson.setName(person.name());
            newPerson.setLastName(person.lastName());
            newPerson.setPhone(person.phone());
            newPerson.setCellPhone(person.cellPhone());
            newPerson.setEmail(person.email());

            personRepository.save(newPerson);

            // tipo da pessoa
            if (person.personType().equals("F")) {

                var newNaturalPerson = new NaturalPerson();
                Timestamp now = Timestamp.from(Instant.now());

                newNaturalPerson.setPerson(newPerson);
                newNaturalPerson.setRegistrationDate(now);
                newNaturalPerson.setBirthDate(person.birthDate());
                newNaturalPerson.setCpf(person.cpf());
                newNaturalPerson.setRg(person.rg());
                if (person.rgEmissionDate() != null) {
                    newNaturalPerson.setRgEmissionDate(person.rgEmissionDate());
                }
                if (person.rgEmission() != null) {
                    newNaturalPerson.setRgEmission(person.rgEmission());
                }
                newNaturalPerson.setGender(person.gender());
                newNaturalPerson.setMaritalStatus(person.maritalStatus());
                if (person.cityOfBirth() != null) {
                    newNaturalPerson.setCityOfBirth(person.cityOfBirth());
                }
                if (person.stateOfBirth() != null) {
                    newNaturalPerson.setStateOfBirth(person.stateOfBirth());
                }
                newNaturalPerson.setMotherName(person.motherName());
                newNaturalPerson.setFatherName(person.fatherName());
                if (person.education() != null) {
                    newNaturalPerson.setEducation(person.education());
                }
                if (person.institutionEducation() != null) {
                    newNaturalPerson.setInstitutionEducation(person.education());
                }
                if (person.occupation() != null) {
                    newNaturalPerson.setOccupation(person.occupation());
                }
                if (person.observations() != null) {
                    newNaturalPerson.setObservations(person.observations());
                }
                newNaturalPerson.setLastUpdate(now);

                naturalPersonRepository.save(newNaturalPerson);

            } else if (person.personType().equals("J")) {

            } else {
                System.err.println("Person type not exists");
                return;
            }

            // endereco
            var personAddress = new Address();

            personAddress.setPerson(newPerson);
            personAddress.setStreet(person.street());
            personAddress.setDistrict(person.district());
            personAddress.setCity(person.city());
            personAddress.setState(person.state());
            personAddress.setCep(person.cep());

            if (person.complement() != null) {
                personAddress.setComplement(person.complement());
            }

            addressRepository.save(personAddress);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
