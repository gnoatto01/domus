package com.br.soluctions.attos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.soluctions.attos.entities.MembroDePatrulha;

public interface MembroDePatrulhaRepository extends JpaRepository<MembroDePatrulha, Long > {
    
   Optional<MembroDePatrulha> findByNome(String nome); 
}
