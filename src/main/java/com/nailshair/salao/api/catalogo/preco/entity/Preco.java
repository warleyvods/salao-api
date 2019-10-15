package com.nailshair.salao.api.catalogo.preco.entity;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "preco")
@EqualsAndHashCode(callSuper = false)
public class Preco extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Preço total")
    @Column(name = "preco_total")
    private Double precoTotal;

    @ApiModelProperty(notes = "Desconto")
    @Column(name = "desconto")
    private Double desconto;

    @ApiModelProperty(notes = "Preco de frete")
    @Column(name = "preco_frete")
    private Double precoFrete;

    @ApiModelProperty(notes = "Booleano de Produto")
    @Column(name = "ativo", nullable = false)
    private Double outrosCustos;

}
