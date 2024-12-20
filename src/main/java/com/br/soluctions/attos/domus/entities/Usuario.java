package com.br.soluctions.attos.domus.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.br.soluctions.attos.domus.dtos.RequisicaoDeLogin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "usuario_id")
    private UUID usuarioId; 

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa; 

    @Column(unique = true)
    private String usuario; 

    @Column(nullable = false)
    private String senha;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "tb_nivel_acesso_usuario", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "nivel_acesso_id"))
    @Column(name = "nivel_acesso")
    private Set<NivelDeAcesso> nivelDeAcesso; 

    @Column(name = "tenant_id")
    private String tenantId; 

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<NivelDeAcesso> getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(Set<NivelDeAcesso> nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    } 

     public boolean isLoginCorreto(RequisicaoDeLogin requisicaoDeLogin, PasswordEncoder passwordEncoder) {

        return passwordEncoder.matches(requisicaoDeLogin.senha(), this.senha);
    }

    public boolean isAdmin() {
        return getNivelDeAcesso()
                .stream()
                .anyMatch(nivelAcesso -> nivelAcesso.getNomeNivelDeAcesso().equalsIgnoreCase(NivelDeAcesso.Valores.ADMINISTRADOR.name()));
    }

    


}
