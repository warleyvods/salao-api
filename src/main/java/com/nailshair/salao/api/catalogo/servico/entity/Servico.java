package com.nailshair.salao.api.catalogo.servico.entity;

import com.nailshair.salao.api.catalogo.unidade.entity.Unidade;
import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "servico")
@EqualsAndHashCode(callSuper = false)
public class Servico extends EntidadeAbstrata {

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "nome_servico")
    private String nomeServico;

    @Column(name = "custo_servico")
    private Double custo;

    @Column(name = "valor_servico")
    private Double valor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unidade_servico_id")
    private Unidade unidadeServico;

}
