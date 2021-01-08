package com.pjc.api.controller;

import com.pjc.api.entity.AlbumEntity;
import com.pjc.api.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("albuns")
public class AlbumController {

    @Autowired
    AlbumService service;

    @GetMapping
    public ResponseEntity get(@PathVariable("page") Integer page,
                              @RequestParam(name = "ordem", required = true, defaultValue = "") Integer ordem,
                              @RequestParam(name = "filtro", required = false, defaultValue = "") String filtro) {
        return service.albuns(page, ordem, filtro); /// FIX Page
    }

    @PostMapping
    public ResponseEntity post(@RequestBody AlbumEntity album) {
        return ResponseEntity.ok("Posting");
    }

    @PutMapping
    public ResponseEntity put(@RequestBody AlbumEntity album) {
        return ResponseEntity.ok("Putting");
    }
}
