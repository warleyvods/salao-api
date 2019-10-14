package com.nailshair.salao.api.catalogo.estoque.entity;

import com.nailshair.salao.api.catalogo.produto.entity.Produto;
import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Estoque extends EntidadeAbstrata {

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "data_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDaCompra;

    @Column(name = "data_validade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataValidade;


}
