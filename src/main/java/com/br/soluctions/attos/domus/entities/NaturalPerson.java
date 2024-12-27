package com.br.soluctions.attos.domus.entities;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_natural_person")
public class NaturalPerson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long naturalPersonId; 

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person; 

   
    private Date birthDate; 

    private String cpf; 

    
    private String rg; 

   
    private Date rgEmissionDate; 

    private String rgEmission; 

    private String gender; 

    @OneToOne
    @JoinColumn(name = "marital_status_id")
    private MaritalStatus maritalStatus;

    private String nationality; 

    private String cityOfBirth;
    
    private String stateOfBirth; 

   
    private String motherName; 

    private String fatherName;

    private String education; 

    
    private String institutionEducation; 

    private String occupation; 

    private String observations; 

    private Timestamp registrationDate; 

    
    private Timestamp lastUpdate;

    public Long getNaturalPersonId() {
        return naturalPersonId;
    }

    public void setNaturalPersonId(Long naturalPersonId) {
        this.naturalPersonId = naturalPersonId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getRgEmissionDate() {
        return rgEmissionDate;
    }

    public void setRgEmissionDate(Date rgEmissionDate) {
        this.rgEmissionDate = rgEmissionDate;
    }

    public String getRgEmission() {
        return rgEmission;
    }

    public void setRgEmission(String rgEmission) {
        this.rgEmission = rgEmission;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public String getStateOfBirth() {
        return stateOfBirth;
    }

    public void setStateOfBirth(String stateOfBirth) {
        this.stateOfBirth = stateOfBirth;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getInstitutionEducation() {
        return institutionEducation;
    }

    public void setInstitutionEducation(String institutionEducation) {
        this.institutionEducation = institutionEducation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    } 

    

     
}
