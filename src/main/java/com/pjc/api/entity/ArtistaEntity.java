package com.pjc.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Artistas")
public class ArtistaEntity extends BaseEntity {

    private String nome;

    @OneToMany(targetEntity= AlbumEntity.class, mappedBy="artista",cascade= CascadeType.ALL)
    private List<AlbumEntity> albuns;
}
