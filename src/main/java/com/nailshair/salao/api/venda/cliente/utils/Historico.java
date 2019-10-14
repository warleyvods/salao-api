package com.nailshair.salao.api.venda.cliente.utils;

import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import com.nailshair.salao.api.venda.cliente.utils.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Historico extends EntidadeAbstrata {

    @Column(name = "data_historico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

}
