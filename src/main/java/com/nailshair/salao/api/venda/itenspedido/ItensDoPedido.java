package com.nailshair.salao.api.venda.itenspedido;

import com.nailshair.salao.api.catalogo.produto.entity.Produto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class ItensDoPedido implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "Tipo de unidade do produto")
    @JoinColumn(name = "produto_id")
    private Produto produto;


    private Integer quantidade;

}
