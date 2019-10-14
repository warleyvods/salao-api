package com.nailshair.salao.api.mercadoria.entity;

import com.nailshair.salao.api.arquiteturabase.entidade.EntidadeAbstrata;
import com.nailshair.salao.api.distribuidor.entity.Distribuidor;
import com.nailshair.salao.api.produto.entity.Produto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Mercadoria extends EntidadeAbstrata {

    private Produto produto;
    private Date dataDaCompra;
    private String dataValidade;
    private Distribuidor distribuidor;

}
