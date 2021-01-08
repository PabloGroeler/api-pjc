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

    @GetMapping
    public ResponseEntity get(@PathVariable("page") Integer page,
                              @RequestParam(name = "ordem", required = true, defaultValue = "") Integer ordem,
                              @RequestParam(name = "filtro", required = false, defaultValue = "") String filtro) {
        return service.artistas(page, ordem, filtro);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ArtistaEntity artista) {
        return ResponseEntity.ok("Posting");
    }

    @PutMapping
    public ResponseEntity put(@RequestBody ArtistaEntity artista) {
        return ResponseEntity.ok("Putting");
    }
}
