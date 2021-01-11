package com.pjc.api.repository;

import com.pjc.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String username);
}
