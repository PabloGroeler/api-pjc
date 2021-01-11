package com.pjc.api.repository;

import com.pjc.api.entity.Artista;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArtistaRepository extends JpaRepository<Artista, Long>, JpaSpecificationExecutor<Artista> {

//    List<AlbumEntity> FindAlbunsByNome(String nome); /// FIX

    class Specifications {
        public static Specification<Artista> nomeQueContem(String nome) {
            return (root, criteriaQuery, cb) -> cb.like(root.get("nome"), "%" + nome + "%");
        }
    }

}
