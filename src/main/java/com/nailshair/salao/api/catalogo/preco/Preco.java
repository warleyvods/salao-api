package com.nailshair.salao.api.catalogo.preco;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Data
@Embeddable
@EqualsAndHashCode(callSuper = false)
public class Preco {

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
    @Column(name = "outrosCustos")
    private Double outrosCustos;

}
