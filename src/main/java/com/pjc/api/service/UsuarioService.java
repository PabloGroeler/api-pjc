package com.pjc.api.service;

import com.pjc.api.entity.Usuario;
import com.pjc.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Optional<Usuario> usuarioFind = repository.findByUsuario(usuario);
        if (!usuarioFind.isPresent()) {
            throw new UsernameNotFoundException(usuario);
        }

        return new User(usuarioFind.get().getUsuario(), usuarioFind.get().getSenha(), emptyList());
    }

    public ResponseEntity salvar(Usuario usuario) {

        Optional<Usuario> byUsuario = repository.findByUsuario(usuario.getUsuario());

        if (byUsuario.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já cadastrado");

        repository.save(usuario);
        return ResponseEntity.ok("Usuario salvo com sucesso.");
    }
}
