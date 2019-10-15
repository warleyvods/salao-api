package com.nailshair.salao.api.venda.pagamento.entity;


import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import com.nailshair.salao.api.venda.pedido.TipoDePagamento;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Pagamento extends EntidadeAbstrata {

    @Column(name = "tipo_de_pagamento")
    @ApiModelProperty(notes = "Enum tipo de pagamento")
    @Enumerated(EnumType.STRING)
    private TipoDePagamento formaDePagamento;

}
