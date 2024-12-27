package com.br.soluctions.attos.domus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.soluctions.attos.domus.entities.AccessLevel;

public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> {
    AccessLevel findByAccessLevelName(String accessLevelName); 
}
