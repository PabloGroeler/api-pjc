package com.pjc.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Usuario extends Base {

    private String usuario;

    private String senha;
}
