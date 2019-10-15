package com.nailshair.salao.api.venda.cliente.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

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
public class Cliente extends Pessoa{

}
