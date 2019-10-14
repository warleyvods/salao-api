package com.nailshair.salao.api.utils.categoria;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Categoria extends EntidadeAbstrata {

    @Column(name = "nome_categoria")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "sub_categoria_id")
    private SubCategoria subCategoria;

}
