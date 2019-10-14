package com.nailshair.salao.api.utils.categoria;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Marca extends EntidadeAbstrata {

    @Column(name = "marca")
    private String nome;

}
