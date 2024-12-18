package com.br.soluctions.attos.domus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.soluctions.attos.domus.entities.NivelDeAcesso;

public interface NivelDeAcessoRepository extends JpaRepository<NivelDeAcesso, Long> {
    NivelDeAcesso findByNomeNivelDeAcesso(String nomeNivelDeAcesso); 
}
