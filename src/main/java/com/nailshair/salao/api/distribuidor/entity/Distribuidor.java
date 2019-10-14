package com.nailshair.salao.api.distribuidor.entity;

import com.nailshair.salao.api.arquiteturabase.entidade.EntidadeAbstrata;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entidade Distribuidor
 *
 * @author Warley Vinicius
 * @since 13/10/2019
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Distribuidor extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Nome do Distribuidor")
    @Column(name = "nome_distribuidor")
    private String nome;

    @ApiModelProperty(notes = "CNPJ do distribuidor")
    @Column(name = "cnpj_distribuidor")
    private String cnpj;

    @ApiModelProperty(notes = "Endereço do distribuidor")
    @Column(name = "endereco_distribuidor")
    private String endereco;

}

