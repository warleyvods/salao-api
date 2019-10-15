package com.nailshair.salao.api.catalogo.categoria;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class SubCategoria extends EntidadeAbstrata {

    @Column(name = "nome_sub_categoria")
    private String nome;

}
