package com.pjc.api.repository;

import com.pjc.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String username);
}
