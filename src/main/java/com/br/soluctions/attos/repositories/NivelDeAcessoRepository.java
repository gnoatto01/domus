package com.br.soluctions.attos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.soluctions.attos.entities.NivelDeAcesso;

public interface NivelDeAcessoRepository extends JpaRepository<NivelDeAcesso, Long> {
    
    NivelDeAcesso findByNomeNivelAcesso(String nomeNivelAcesso); 
}
