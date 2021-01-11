package com.pjc.api.controller;

import com.pjc.api.entity.Usuario;
import com.pjc.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("")
    public ResponseEntity login(@RequestBody Usuario usuario) {
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        return service.salvar(usuario);
    }
}
