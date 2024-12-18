package com.br.soluctions.attos.domus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estado_civil")
public class EstadoCivil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_civil_id")
    private Long estadoCivilId; 

    @Column(name = "estado_civil")
    private String estadoCivil;

    public Long getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(Long estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    } 


    
}
