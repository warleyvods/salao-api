package com.nailshair.salao.api.catalogo.servico.entity;

import com.nailshair.salao.api.utils.categoria.Unidade;
import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Servico extends EntidadeAbstrata {

    private Boolean ativo;
    private String nomeServico;
    private Double custo;
    private Double valor;
    private Unidade unidadeServico;

}
