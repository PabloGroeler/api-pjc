package com.pjc.api.controller;

import com.pjc.api.entity.ArtistaEntity;
import com.pjc.api.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("artistas")
public class ArtistaController {

    @Autowired
    ArtistaService service;

    @GetMapping()
    public ResponseEntity get(@RequestParam(name = "ordem", required = false, defaultValue = "") Integer ordem,
                              @RequestParam(name = "filtro", required = false, defaultValue = "") String filtro) {
        return service.artistas(ordem, filtro);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ArtistaEntity artista) {
        return service.post(artista);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id,
                              @RequestBody ArtistaEntity artista) {
        return service.put(id, artista);
    }
}
