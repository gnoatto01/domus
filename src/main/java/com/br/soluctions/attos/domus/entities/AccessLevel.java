package com.br.soluctions.attos.domus.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_access_level")
public class AccessLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long accessLevelId;

    private String accessLevelName;

    public Long getAccessLevelId() {
        return accessLevelId;
    }

    public void setAccessLevelId(Long accessLevelId) {
        this.accessLevelId = accessLevelId;
    }

    public String getAccessLevelName() {
        return accessLevelName;
    }

    public void setAccessLevelName(String accessLevelName) {
        this.accessLevelName = accessLevelName;
    }

    public enum Values {
        ADMINISTRADOR(1L),
        MODERADOR(2L),
        COMANDANTE(3L),
        SECRETARIA(4L),
        USUARIO(5);

        long accesLevelId;

        Values(long accesLevelId) {
            this.accesLevelId = accesLevelId;
        }

        public long getAccesLevelId() {
            return accesLevelId;
        }
    }

}
