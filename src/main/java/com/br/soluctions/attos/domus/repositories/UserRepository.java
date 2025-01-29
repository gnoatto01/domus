package com.br.soluctions.attos.domus.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.soluctions.attos.domus.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    @Query(value = "select count(1) > 0 from tb_person p where lower(p.email) like lower(?1)", nativeQuery = true)
    boolean findByPersonEmail(String email);
}
