package com.pjc.api.service;

import com.pjc.api.entity.Album;
import com.pjc.api.repository.AlbumRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AlbumService extends BaseService {

    @Autowired
    AlbumRepository repository;

    @Autowired
    FileUploader uploader;

   public ResponseEntity albuns(Integer page, Integer ordem, String nome) {
        Specification specification = null;

        if (!StringUtils.isEmpty(nome)) {
            specification = getSpecification(specification).and(AlbumRepository.Specifications.nomeQueContem(nome));
        }

        Page albuns = repository.findAll(specification, PageRequest.of(page - 1, 30, Sort.by(GetOrder(ordem), "nome")));
        if (albuns.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Album(ns) não encontrado(s).");
        }

        return ResponseEntity.ok(albuns);

    }

    public ResponseEntity post(Album album) {
        repository.save(album);
        return ResponseEntity.ok("Album salvo com sucesso");
    }

    public ResponseEntity put(Long id, Album album) {
        Optional<Album> findAlbum = repository.findById(id);
        if (!findAlbum.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Album não encontrado.");
        }

        album.setId(findAlbum.get().getId());
        repository.save(album);
        return ResponseEntity.ok("Album atualizado com sucesso.");
    }

    public ResponseEntity AddImagem() {
        try {
//            uploader.upload(files);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("Imagens adicionadas com sucesso.");
    }
}
