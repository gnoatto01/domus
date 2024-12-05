package com.br.soluctions.attos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_membro_de_patrulha")
public class MembroDePatrulha extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membroPatrulhaId; 

    @Column(name = "nivel_escolar")
    private String nivelEscolar; 

    @Column(name = "instituicao_ensino")
    private String instituicaoDeEnsino; 

    private String religiao; 

    @Column(name = "igreja_pertence")
    private String igrejaAQualPertence; 

    @Column(name = "nome_pastor")
    private String nomeDoPastor; 

    private String alergia;

    private String disturbio; 

    @Column(name = "restricao_atividades_fisicas")
    private String restricaoAtividadesFisicas; 

    @Column(name = "sabe_nadar")
    private Boolean sabeNadar; 

    @Column(name = "medicacao_continua")
    private String medicacaoContinua; 

    @Column(name = "tipo_sanguineo")
    private char tipoSanguineo; 

    @Column(name = "fator_rh")
    private char fatorRh; 

    @Column(name = "plano_saude")
    private String planoDeSaude; 

    @Column(name = "hospital_atendimento")
    private String hospitalDeAtendimento; 

    @Column(name = "informacoes_adicionais")
    private String informacoesAdicionais; 

    @Column(name = "tamanho_camiseta")
    private String tamanhoDaCamiseta; 

    @Column(name = "tamanho_colete")
    private String tamanhoDoColete; 

    @Column(name = "nome_pai")
    private String nomeDoPai; 

    @Column(name = "telefone_pai")
    private String telefoneDoPai; 

    @Column(name = "nome_mae")
    private String nomeDaMae; 

    @Column(name = "telefone_mae")
    private String telefoneDaMae; 

    @Column(name = "email_contato")
    private String emailParaContato; 

    @Column(name = "religiao_pais")
    private String religiaoPais; 

    @Column(name = "igreja_familia")
    private String igrejaDaFamilia; 

    @Column(name = "telefone_auxilar")
    private String telefoneAuxiliar; 

    private String bairro;

    private String cidade; 

    private String cep; 

    @Column(name = "ativdade_externa")
    private Boolean ativadeExterna; 

    @Column(name = "ativdade_interna")
    private Boolean atividadeInterna;


    public String getNivelEscolar() {
        return nivelEscolar;
    }
    public void setNivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }
    public String getInstituicaoDeEnsino() {
        return instituicaoDeEnsino;
    }
    public void setInstituicaoDeEnsino(String instituicaoDeEnsino) {
        this.instituicaoDeEnsino = instituicaoDeEnsino;
    }
    public String getReligiao() {
        return religiao;
    }
    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }
    public String getIgrejaAQualPertence() {
        return igrejaAQualPertence;
    }
    public void setIgrejaAQualPertence(String igrejaAQualPertence) {
        this.igrejaAQualPertence = igrejaAQualPertence;
    }
    public String getNomeDoPastor() {
        return nomeDoPastor;
    }
    public void setNomeDoPastor(String nomeDoPastor) {
        this.nomeDoPastor = nomeDoPastor;
    }
    public String getAlergia() {
        return alergia;
    }
    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    public String getDisturbio() {
        return disturbio;
    }
    public void setDisturbio(String disturbio) {
        this.disturbio = disturbio;
    }
    public String getRestricaoAtividadesFisicas() {
        return restricaoAtividadesFisicas;
    }
    public void setRestricaoAtividadesFisicas(String restricaoAtividadesFisicas) {
        this.restricaoAtividadesFisicas = restricaoAtividadesFisicas;
    }
    public Boolean getSabeNadar() {
        return sabeNadar;
    }
    public void setSabeNadar(Boolean sabeNadar) {
        this.sabeNadar = sabeNadar;
    }
    public String getMedicacaoContinua() {
        return medicacaoContinua;
    }
    public void setMedicacaoContinua(String medicacaoContinua) {
        this.medicacaoContinua = medicacaoContinua;
    }
    public char getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(char tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    public char getFatorRh() {
        return fatorRh;
    }
    public void setFatorRh(char fatorRh) {
        this.fatorRh = fatorRh;
    }
    public String getPlanoDeSaude() {
        return planoDeSaude;
    }
    public void setPlanoDeSaude(String planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }
    public String getHospitalDeAtendimento() {
        return hospitalDeAtendimento;
    }
    public void setHospitalDeAtendimento(String hospitalDeAtendimento) {
        this.hospitalDeAtendimento = hospitalDeAtendimento;
    }
    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }
    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }
    public String getTamanhoDaCamiseta() {
        return tamanhoDaCamiseta;
    }
    public void setTamanhoDaCamiseta(String tamanhoDaCamiseta) {
        this.tamanhoDaCamiseta = tamanhoDaCamiseta;
    }
    public String getTamanhoDoColete() {
        return tamanhoDoColete;
    }
    public void setTamanhoDoColete(String tamanhoDoColete) {
        this.tamanhoDoColete = tamanhoDoColete;
    }
    public String getNomeDoPai() {
        return nomeDoPai;
    }
    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }
    public String getTelefoneDoPai() {
        return telefoneDoPai;
    }
    public void setTelefoneDoPai(String telefoneDoPai) {
        this.telefoneDoPai = telefoneDoPai;
    }
    public String getNomeDaMae() {
        return nomeDaMae;
    }
    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }
    public String getTelefoneDaMae() {
        return telefoneDaMae;
    }
    public void setTelefoneDaMae(String telefoneDaMae) {
        this.telefoneDaMae = telefoneDaMae;
    }
    public String getEmailParaContato() {
        return emailParaContato;
    }
    public void setEmailParaContato(String emailParaContato) {
        this.emailParaContato = emailParaContato;
    }
    public String getReligiaoPais() {
        return religiaoPais;
    }
    public void setReligiaoPais(String religiaoPais) {
        this.religiaoPais = religiaoPais;
    }
    public String getIgrejaDaFamilia() {
        return igrejaDaFamilia;
    }
    public void setIgrejaDaFamilia(String igrejaDaFamilia) {
        this.igrejaDaFamilia = igrejaDaFamilia;
    }
    public String getTelefoneAuxiliar() {
        return telefoneAuxiliar;
    }
    public void setTelefoneAuxiliar(String telefoneAuxiliar) {
        this.telefoneAuxiliar = telefoneAuxiliar;
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
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public Boolean getAtivadeExterna() {
        return ativadeExterna;
    }
    public void setAtivadeExterna(Boolean ativadeExterna) {
        this.ativadeExterna = ativadeExterna;
    }
    public Boolean getAtividadeInterna() {
        return atividadeInterna;
    }
    public void setAtividadeInterna(Boolean atividadeInterna) {
        this.atividadeInterna = atividadeInterna;
    }
    public Long getMembroPatrulhaId() {
        return membroPatrulhaId;
    }
    public void setMembroPatrulhaId(Long membroPatrulhaId) {
        this.membroPatrulhaId = membroPatrulhaId;
    } 

    

    
}
