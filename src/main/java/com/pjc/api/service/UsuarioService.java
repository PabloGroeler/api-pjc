package com.pjc.api.service;

import com.pjc.api.entity.Usuario;
import com.pjc.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario usuarioFind = repository.findByUsuario(usuario);
        if (usuarioFind == null) {
            throw new UsernameNotFoundException(usuario);
        }

        return new User(usuarioFind.getUsuario(), usuarioFind.getSenha(), emptyList());
    }

    public ResponseEntity salvar(Usuario usuario) {
        repository.save(usuario);
        return ResponseEntity.ok("Usuario salvo com sucesso.");
    }
}
