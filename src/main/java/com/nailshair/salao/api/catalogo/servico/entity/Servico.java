package com.nailshair.salao.api.catalogo.servico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nailshair.salao.api.catalogo.preco.Preco;
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

    @Embedded
    private Preco precoServico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unidade_servico_id")
    private Unidade unidadeServico;

    @JsonIgnore
    @Transient
    public boolean isInativo() {
        return !this.ativo;
    }

}
