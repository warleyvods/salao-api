package com.nailshair.salao.api.pessoa.entity;

import com.nailshair.salao.api.arquiteturabase.entidade.EntidadeAbstrata;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidade Pessoa
 *
 * @author Warley Vinicius
 * @since 13/10/2019
 */
@Data
@Entity
@Table(name = "pessoa")
@ApiModel(description = "Pessoa/Clientes do Salao Api")
@EqualsAndHashCode(callSuper = false)
public class Pessoa extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Nome da Pessoa/Cliente")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @ApiModelProperty(notes = "CPF da Pessoa/Cliente")
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @ApiModelProperty(notes = "Data de Nascimento da Pessoa/Cliente")
    @Column(name = "data_nascimento")
    private String dataNascimento;

    @ApiModelProperty(notes = "Telefone da Pessoa/Cliente")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @ApiModelProperty(notes = "Instagram da pessoa/Cliente")
    @Column(name = "instagram", length = 15)
    private String instagram;

    @ApiModelProperty(notes = "Indicacao do cliente")
    @Column(name = "indicacao", length = 50)
    private String indicacao;

    @Email
    @ApiModelProperty(notes = "Email do  Cliente/Pessoa")
    @Column(name = "email")
    private String email;

    @ApiModelProperty(notes = "Endereço do Cliente/Pessoa")
    @Column(name = "endereco", length = 30)
    private String endereco;

    @ApiModelProperty(notes = "CEP do Cliente/Pessoa")
    @Column(name = "cep", length = 15)
    private String cep;

    @ApiModelProperty(notes = "Logradouro do Cliente/Pessoa")
    @Column(name = "logradouro", length = 50)
    private String logradouro;

}
