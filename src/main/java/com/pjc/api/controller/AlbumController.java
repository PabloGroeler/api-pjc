package com.pjc.api.controller;

import com.pjc.api.dto.ImagemDto;
import com.pjc.api.entity.Album;
import com.pjc.api.service.AlbumService;
import com.pjc.api.service.FileUploader;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("albuns")
public class AlbumController {

    @Autowired
    AlbumService service;

    @Autowired
    FileUploader uploader;

    @GetMapping("/{page}")
    public ResponseEntity get(@PathVariable("page") Integer page,
                              @RequestParam(name = "ordem", required = false, defaultValue = "") Integer ordem,
                              @RequestParam(name = "filtro", required = false, defaultValue = "") String filtro) {
        return service.albuns(page, ordem, filtro);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Album album) {
        return service.post(album);
    }

    @PutMapping
    public ResponseEntity put(@PathVariable("id") Long id,
                              @RequestBody Album album) {
        return service.put(id, album);
    }

    @PostMapping("upload")
    public ResponseEntity uploadImagem(@RequestParam("imagem") List<MultipartFile> files) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, ServerException, ErrorResponseException, XmlParserException, InsufficientDataException, InternalException {
        uploader.upload(files);

        return ResponseEntity.ok("teste");
    }
}
