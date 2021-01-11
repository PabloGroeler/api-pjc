package com.pjc.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Artistas")
public class Artista extends Base {

    private String nome;

    @OneToMany(targetEntity= Album.class, mappedBy="artista",cascade= CascadeType.ALL)
    private List<Album> albuns;
}
