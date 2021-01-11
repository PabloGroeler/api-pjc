package com.pjc.api.repository;

import com.pjc.api.entity.Album;
import com.pjc.api.entity.Artista;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlbumRepository extends JpaRepository<Album, Long>, JpaSpecificationExecutor<Album> {

    class Specifications {
        public static Specification<Artista> nomeQueContem(String nome) {
            return (root, criteriaQuery, cb) -> cb.like(root.get("nome"), "%" + nome + "%");
        }
    }
}
