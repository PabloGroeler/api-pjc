package com.pjc.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Albuns")
public class AlbumEntity extends BaseEntity {

    private String nome;

    @Transient /// FIX
    private List<byte[]> capa;

    @ManyToOne
    @JoinColumn(name="artista", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnoreProperties("albuns")
    private ArtistaEntity artista;
}
