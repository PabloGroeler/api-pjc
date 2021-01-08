package com.pjc.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Albuns")
public class AlbumEntity extends BaseEntity {

    private String nome;

    private List<byte[]> capa;

    @ManyToOne
    @JoinColumn(name="artista", referencedColumnName = "id", insertable = false, updatable = false)
    private ArtistaEntity artistaEntity;
}
