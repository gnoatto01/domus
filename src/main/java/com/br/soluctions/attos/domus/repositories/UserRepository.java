package com.br.soluctions.attos.domus.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.soluctions.attos.domus.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username); 

    Optional<User> findByPersonEmail(String email); 
}
