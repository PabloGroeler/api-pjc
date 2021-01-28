package com.pjc.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class LiveController {

    @GetMapping()
    public ResponseEntity isLive() {
        return ResponseEntity.ok("Bem vindo! PJC-API Works!!");
    }
}
