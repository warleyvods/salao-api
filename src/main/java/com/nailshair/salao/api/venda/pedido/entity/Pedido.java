package com.nailshair.salao.api.venda.pedido.entity;

import com.nailshair.salao.api.catalogo.produto.entity.Produto;
import com.nailshair.salao.api.configuracao.empresa.funcionario.entity.Funcionario;
import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import com.nailshair.salao.api.venda.cliente.entity.Pessoa;
import com.nailshair.salao.api.venda.pagamento.entity.Pagamento;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "pedido")
@EqualsAndHashCode(callSuper = false)
public class Pedido extends EntidadeAbstrata {

      @Column(name = "data_emissao_pedido")
      @Temporal(TemporalType.TIMESTAMP)
      private Date dataEmissaoPedido;

      @Column(name = "data_entrega_pedido")
      @Temporal(TemporalType.TIMESTAMP)
      private Date dataEntregaPedido;

      @ManyToOne(cascade = CascadeType.ALL)
      @ApiModelProperty(notes = "Tipo de unidade do produto")
      @JoinColumn(name = "cliente_id")
      private Pessoa cliente;

      @ManyToOne(cascade = CascadeType.ALL)
      @ApiModelProperty(notes = "Tipo de unidade do produto")
      @JoinColumn(name = "vendedor_id")
      private Funcionario vendedor;

      @ManyToOne(cascade = CascadeType.ALL)
      @ApiModelProperty(notes = "Tipo de unidade do produto")
      @JoinColumn(name = "produto_id")
      private Produto produto;

      @ManyToOne(cascade = CascadeType.ALL)
      @ApiModelProperty(notes = "Tipo de unidade do produto")
      @JoinColumn(name = "pagamento_id")
      private Pagamento pagamento;

}
