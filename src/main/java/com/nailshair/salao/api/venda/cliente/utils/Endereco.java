package com.nailshair.salao.api.venda.cliente.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Endereco extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Booleano de ativacao/desativacao do endereço Cliente/Pessoa")
    @Column(name = "ativo")
    private Boolean ativo;

    @ApiModelProperty(notes = "Booleano de ativacao/desativacao do endereço padrao Cliente/Pessoa")
    @Column(name = "enderecoPadrao")
    private Boolean enderecoPadrao;

    @ApiModelProperty(notes = "CEP do Cliente/Pessoa")
    @Column(name = "cep", length = 15, nullable = false)
    private String cep;

    @ApiModelProperty(notes = "Logradouro do Cliente/Pessoa")
    @Column(name = "logradouro", length = 50)
    private String logradouro;

    @ApiModelProperty(notes = "Endereço do Cliente/Pessoa")
    @Column(name = "endereco", length = 30)
    private String numero;

    @ApiModelProperty(notes = "Complemento do Cliente/Pessoa")
    @Column(name = "complemento", length = 30)
    private String complemento;

    @ApiModelProperty(notes = "Bairro do Cliente/Pessoa")
    @Column(name = "bairro", length = 50)
    private String bairro;

    @JsonIgnore
    @Transient
    public boolean isInativo() {
        return !this.ativo;
    }

}
