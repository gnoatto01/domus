package com.br.soluctions.attos.domus.entities;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica {
    @Column(name = "pessoa_fisica_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pessoaFisicaId; 

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa; 

    @Column(name = "data_nascimento")
    private Date dataDeNascimento; 

    private String cpf; 

    @Column(name = "numero_rg")
    private String numeroRg; 

    @Column(name = "data_emissao_rg")
    private Date dataEmissaoRg; 

    @Column(name = "orgao_emissor_rg")
    private String orgaoEmissorRg; 

    private String genero; 

    @OneToOne
    @JoinColumn(name = "estado_civil_id")
    private EstadoCivil estadoCivil;

    private String nacionalidade; 

    @Column(name = "cidade_naturalidade")
    private String cidadeNaturalidade;
    
    @Column(name = "estado_naturalidade")
    private String estadoNaturalidade; 

    @Column(name = "nome_mae")
    private String nomeDaMae; 

    @Column(name = "nome_pai")
    private String nomeDoPai;

    private String escolaridade; 

    @Column(name = "local_ensino")
    private String localDeEnsino; 

    private String profissao; 

    private String observacoes; 

    @Column(name = "data_cadastro")
    private Timestamp dataDeCadastro; 

    @Column(name = "ultima_atualizacao")
    private Timestamp ultimaAtualizacao;

    public Long getPessoaFisicaId() {
        return pessoaFisicaId;
    }

    public void setPessoaFisicaId(Long pessoaFisicaId) {
        this.pessoaFisicaId = pessoaFisicaId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public Date getDataEmissaoRg() {
        return dataEmissaoRg;
    }

    public void setDataEmissaoRg(Date dataEmissaoRg) {
        this.dataEmissaoRg = dataEmissaoRg;
    }

    public String getOrgaoEmissorRg() {
        return orgaoEmissorRg;
    }

    public void setOrgaoEmissorRg(String orgaoEmissorRg) {
        this.orgaoEmissorRg = orgaoEmissorRg;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCidadeNaturalidade() {
        return cidadeNaturalidade;
    }

    public void setCidadeNaturalidade(String cidadeNaturalidade) {
        this.cidadeNaturalidade = cidadeNaturalidade;
    }

    public String getEstadoNaturalidade() {
        return estadoNaturalidade;
    }

    public void setEstadoNaturalidade(String estadoNaturalidade) {
        this.estadoNaturalidade = estadoNaturalidade;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getLocalDeEnsino() {
        return localDeEnsino;
    }

    public void setLocalDeEnsino(String localDeEnsino) {
        this.localDeEnsino = localDeEnsino;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Timestamp getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Timestamp dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Timestamp getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Timestamp ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    } 

    

     
}
