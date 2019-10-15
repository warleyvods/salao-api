package com.nailshair.salao.api.catalogo.unidade.entity;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Unidade extends EntidadeAbstrata {

    @Column(name = "descricao_unidade")
    private String descricao;

    @Column(name = "sigla")
    private String sigla;

}
