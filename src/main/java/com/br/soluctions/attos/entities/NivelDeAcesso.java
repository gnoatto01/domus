package com.br.soluctions.attos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_nivel_acesso")
public class NivelDeAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nivel_acesso_id")
    private Long nivelDeAcessoId; 

    @Column(name = "nome_nivel_acesso")
    private String nomeNivelAcesso;

    public Long getNivelDeAcessoId() {
        return nivelDeAcessoId;
    }

    public void setNivelDeAcessoId(Long nivelDeAcessoId) {
        this.nivelDeAcessoId = nivelDeAcessoId;
    }

    public String getNomeNivelAcesso() {
        return nomeNivelAcesso;
    }

    public void setNomeNivelAcesso(String nomeNivelAcesso) {
        this.nomeNivelAcesso = nomeNivelAcesso;
    } 

    public enum Values {
        ADMINISTRADOR(1L),
        MODERADOR(2L),
        COMANDANTE(3L),
        SECRETARIA(4L),
        USUARIO(5);

        long nivelDeAcessoId;

        Values(long nivelDeAcessoId) {
            this.nivelDeAcessoId = nivelDeAcessoId;
        }

        public long getNivelAcessoId() {
            return nivelDeAcessoId;
        }
    }
    }


