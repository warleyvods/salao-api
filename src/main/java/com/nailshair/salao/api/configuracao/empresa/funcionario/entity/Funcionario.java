package com.nailshair.salao.api.configuracao.empresa.funcionario.entity;

import com.nailshair.salao.api.configuracao.empresa.usuario.entity.Usuario;
import com.nailshair.salao.api.venda.cliente.entity.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Funcionario extends Pessoa {

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
