package com.pjc.api.repository;

import com.pjc.api.entity.AlbumEntity;
import com.pjc.api.entity.ArtistaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ArtistaRepository extends JpaRepository<ArtistaEntity, Long>, JpaSpecificationExecutor<ArtistaEntity> {

//    List<AlbumEntity> FindAlbunsByNome(String nome); /// FIX

    class Specifications {
        public static Specification<ArtistaEntity> nomeQueContem(String nome) {
            return (root, criteriaQuery, cb) -> cb.like(root.get("nome"), "%" + nome + "%");
        }
    }

}
