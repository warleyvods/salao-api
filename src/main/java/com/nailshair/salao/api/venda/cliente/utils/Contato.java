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
public class Contato extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Nome do Contato Cliente/Pessoa")
    @Column(name = "nome_contato")
    private String nomeContato;

    @ApiModelProperty(notes = "Cargo do contato Cliente/Pessoa")
    @Column(name = "cargo")
    private String cargoContato;

    @ApiModelProperty(notes = "Telefone do contato Cliente/Pessoa")
    @Column(name = "telefone_contato")
    private String telefoneContato;

    @ApiModelProperty(notes = "Email do Cliente/Pessoa")
    @Column(name = "email_contato")
    private String emailContato;

}
