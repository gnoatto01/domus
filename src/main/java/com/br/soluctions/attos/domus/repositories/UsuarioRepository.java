package com.br.soluctions.attos.domus.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.soluctions.attos.domus.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByUsuario(String usuario); 
}
