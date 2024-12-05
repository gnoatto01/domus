package com.br.soluctions.attos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Membro extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membro_id")
    private Long membroId; 

    @Column(name = "estado_civil")
    private String estadoCivil; 

    @Column(name = "nome_do_pai")
    private String nomeDoPai; 

    @Column(name = "nome_da_mae")
    private String nomeDaMae; 

    private String cep; 

    private String logradouro; 

    private String bairro; 

    private String cidade; 

    private String estado; 

    @ManyToOne
    @JoinColumn(name = "ministerio_id")
    private Ministerio membroMinisterio; 

    @Column(name = "complemento_endereco")
    private String complememtoEndereco;

    public Long getMembroId() {
        return membroId;
    }

    public void setMembroId(Long membroId) {
        this.membroId = membroId;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplememtoEndereco() {
        return complememtoEndereco;
    }

    public void setComplememtoEndereco(String complememtoEndereco) {
        this.complememtoEndereco = complememtoEndereco;
    }

    public Ministerio getMembroMinisterio() {
        return membroMinisterio;
    }

    public void setMembroMinisterio(Ministerio membroMinisterio) {
        this.membroMinisterio = membroMinisterio;
    } 


}
