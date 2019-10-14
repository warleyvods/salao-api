package com.nailshair.salao.api.configuracao.funcionario.entity;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Funcionario extends EntidadeAbstrata {


}
