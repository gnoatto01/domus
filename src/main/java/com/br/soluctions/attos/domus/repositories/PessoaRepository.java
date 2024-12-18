package com.br.soluctions.attos.domus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.soluctions.attos.domus.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
