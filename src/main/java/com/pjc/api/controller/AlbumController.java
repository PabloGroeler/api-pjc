package com.pjc.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("albuns")
public class AlbumController {

    @GetMapping
    public String teste() {
        return "teste albuns";
    }
}
