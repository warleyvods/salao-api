package com.nailshair.salao.api.produto.entity;

import com.nailshair.salao.api.arquiteturabase.entidade.EntidadeAbstrata;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Produto extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Nome do Produto")
    @Column(name = "nome_produto")
    private String nome;

    @ApiModelProperty(notes = "Marca do produto")
    @Column(name = "marca_produto")
    private String marca;

    @ApiModelProperty(notes = "Modelo do produto")
    @Column(name = "modelo_produto")
    private String modelo;

    @ApiModelProperty(notes = "Quantidade de  Produtos")
    @Column(name = "quantidade_produto")
    private Integer quantidade;

}
