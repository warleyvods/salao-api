package com.nailshair.salao.api.venda.cliente.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import com.nailshair.salao.api.venda.cliente.utils.Contato;
import com.nailshair.salao.api.venda.cliente.utils.DadosBancarios;
import com.nailshair.salao.api.venda.cliente.utils.Endereco;
import com.nailshair.salao.api.venda.cliente.utils.Historico;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.List;

/**
 * Entidade Pessoa
 *
 * @author Warley Vinicius
 * @since 13/10/2019
 */
@Data
@Entity
@ApiModel(description = "Pessoas/Clientes do Salao API")
@EqualsAndHashCode(callSuper = false)
public class Pessoa extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Booleano de ativacao/desativacao Cliente/Pessoa")
    @Column(name = "ativo", length = 15)
    private Boolean ativo;

    @ApiModelProperty(notes = "Nome da Pessoa/Cliente")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @ApiModelProperty(notes = "CPF da Pessoa/Cliente")
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @ApiModelProperty(notes = "RG da Pessoa/Cliente")
    @Column(name = "rg", length = 15, nullable = false)
    private String rg;

    @ApiModelProperty(notes = "Emissor RG da Pessoa/Cliente")
    @Column(name = "emissor_rg", length = 15, nullable = false)
    private String emissorRg;

    @ApiModelProperty(notes = "UF de Emissao do RG da Pessoa/Cliente")
    @Column(name = "uf_rg", length = 15, nullable = false)
    private String ufRg;

    @ApiModelProperty(notes = "Telefone da Pessoa/Cliente")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @ApiModelProperty(notes = "Celular da Pessoa/Cliente")
    @Column(name = "celular", length = 15, nullable = false)
    private String celular;

    @Email
    @ApiModelProperty(notes = "Email do Cliente/Pessoa")
    @Column(name = "email")
    private String email;

    @ApiModelProperty(notes = "Site do Cliente/Pessoa")
    @Column(name = "site")
    private String site;

    @ApiModelProperty(notes = "Data de Nascimento da Pessoa/Cliente")
    @Column(name = "data_nascimento")
    private String dataNascimento;

    @ApiModelProperty(notes = "Observacoes da Pessoa/Cliente")
    @Column(name = "observacoes")
    private String observacoes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    @ApiModelProperty(notes = "Endereco da Pessoa/Cliente")
    private List<Endereco> endereco;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    @ApiModelProperty(notes = "Contatos da Pessoa/Cliente")
    private List<Contato> contato;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_bancarios_id")
    @ApiModelProperty(notes = "Dados Bancarios da Pessoa/Cliente")
    private List<DadosBancarios> dadosBancarios;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "historico_id")
    @ApiModelProperty(notes = "Dados Historicos da Pessoa/Cliente")
    private List<Historico> historico;

    @JsonIgnore
    @Transient
    public boolean isInativo() {
        return !this.ativo;
    }

}
