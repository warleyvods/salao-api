package com.nailshair.salao.api.catalogo.marca.entity;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "marca")
@EqualsAndHashCode(callSuper = false)
public class Marca extends EntidadeAbstrata {

    @Column(name = "nome_marca")
    private String nome;

}
