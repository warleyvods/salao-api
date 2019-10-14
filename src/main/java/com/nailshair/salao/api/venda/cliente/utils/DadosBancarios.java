package com.nailshair.salao.api.venda.cliente.utils;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class DadosBancarios extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Banco do Cliente/Pessoa")
    @Column(name = "banco")
    private String banco;

    @ApiModelProperty(notes = "Agencia do Cliente/Pessoa")
    @Column(name = "agencia")
    private String agencia;

    @ApiModelProperty(notes = "Digito do Cliente/Pessoa")
    @Column(name = "digito")
    private String digito;

    @ApiModelProperty(notes = "Conta Corrente do Cliente/Pessoa")
    @Column(name = "conta_corrente")
    private String contaCorrente;

    @ApiModelProperty(notes = "Digito da Conta Corrente do Cliente/Pessoa")
    @Column(name = "digito_cc")
    private String digitoContaCorrente;

}
