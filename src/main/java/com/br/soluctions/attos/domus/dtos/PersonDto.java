package com.br.soluctions.attos.domus.dtos;

import java.util.Date;

import com.br.soluctions.attos.domus.entities.MaritalStatus;

public record PersonDto(
        String name, String lastName,
        String phone, String cellPhone,
        String email, String personType,
        Date birthDate, String cpf,
        String rg, Date rgEmissionDate,
        String rgEmission, String gender,
        MaritalStatus maritalStatus,
        String cityOfBirth,
        String stateOfBirth, String motherName,
        String fatherName, String education,
        String institutionEducation, String occupation,
        String observations, String street, String district, String city, String state, String cep, String complement) {

}
