package com.pjc.api.service;

import com.pjc.api.entity.ArtistaEntity;
import com.pjc.api.repository.AlbumRepository;
import com.pjc.api.repository.ArtistaRepository;
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

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService extends BaseService {

    @Autowired
    ArtistaRepository repository;

    public ResponseEntity artistas(Integer ordem, String nome) {
        Specification specification = null;

        if (!StringUtils.isEmpty(nome)) {
            specification = getSpecification(specification).and(ArtistaRepository.Specifications.nomeQueContem(nome));
        }

        List<ArtistaEntity> artistas = repository.findAll(specification, Sort.by(GetOrder(ordem), "nome"));
        if (artistas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista(s) não encontrado(s).");
        }

        return ResponseEntity.ok(artistas);
    }

    public ResponseEntity post(ArtistaEntity artista) {
        repository.save(artista);
        return ResponseEntity.ok("Artista salvo com sucesso");
    }

    public ResponseEntity put(Long id, ArtistaEntity artista) {
        Optional<ArtistaEntity> findArtista = repository.findById(id);
        if (!findArtista.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado.");
        }

        artista.setId(findArtista.get().getId());
        repository.save(artista);
        return ResponseEntity.ok("Artista atualizado com sucesso.");
    }
}
