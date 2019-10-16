package com.nailshair.salao.api.configuracao.empresa.usuario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nailshair.salao.api.configuracao.empresa.usuario.TipoPerfil;
import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "usuario")
@EqualsAndHashCode(callSuper = false)
public class Usuario extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Booleano de ativacao do usuario")
    @Column(name = "ativado")
    private Boolean ativo;

    @ApiModelProperty(notes = "Nome do usuario")
    @Column(name = "nome_usuario")
    private String nome;

    @ApiModelProperty(notes = "Email do usuario")
    @Column(name = "email_usuario")
    private String email;

    @ApiModelProperty(notes = "Telefone do usuario")
    @Column(name = "tel_usuario")
    private String telefone;


    @ApiModelProperty(notes = "Tipo Perfil do usuario")
    @Column(name = "tipo_perfil")
    @Enumerated(EnumType.STRING)
    private TipoPerfil tipoPerfil;

    @ApiModelProperty(notes = "Booleano de ativacao do vendedor")
    @Column(name = "vendedor")
    private Boolean vendedor;

    @ApiModelProperty(notes = "Login do usuario")
    @Column(name = "login")
    private String login;

    @ApiModelProperty(notes = "Senha do usuario")
    @Column(name = "senha")
    private String senha;

    @JsonIgnore
    @Transient
    public boolean isInativo() {
        return !this.ativo;
    }

}
