package com.br.soluctions.attos.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ministerio")
public class Ministerio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    private String nomeMinisterio; 

    @OneToMany(mappedBy = "ministerio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Membro> membrosMinisterio = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeMinisterio() {
        return nomeMinisterio;
    }

    public void setNomeMinisterio(String nomeMinisterio) {
        this.nomeMinisterio = nomeMinisterio;
    }

    public List<Membro> getMembrosMinisterio() {
        return membrosMinisterio;
    }

    public void setMembrosMinisterio(List<Membro> membrosMinisterio) {
        this.membrosMinisterio = membrosMinisterio;
    } 

    
    
}
