package com.nailshair.salao.api.catalogo.categoria.entity;

import com.nailshair.salao.api.catalogo.categoria.SubCategoria;
import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "categoria")
@EqualsAndHashCode(callSuper = false)
public class Categoria extends EntidadeAbstrata {

    @Column(name = "nome_categoria")
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_categoria_id")
    private SubCategoria subCategoria;

}
