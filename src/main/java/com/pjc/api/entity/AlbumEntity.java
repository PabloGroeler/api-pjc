package com.pjc.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "Albuns")
public class AlbumEntity extends BaseModel {

    private String nome;

    @ManyToOne
    @JoinColumn(name="artista", referencedColumnName = "id", insertable = false, updatable = false)
    private ArtistaEntity artistaEntity;
}
