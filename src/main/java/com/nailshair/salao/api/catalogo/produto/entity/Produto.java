package com.nailshair.salao.api.catalogo.produto.entity;

import com.nailshair.salao.api.catalogo.categoria.entity.Categoria;
import com.nailshair.salao.api.catalogo.marca.entity.Marca;
import com.nailshair.salao.api.catalogo.unidade.entity.Unidade;
import com.nailshair.salao.api.utils.entidade.EntidadeAbstrata;
import com.nailshair.salao.api.utils.enums.TipoItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Produto extends EntidadeAbstrata {

    @ApiModelProperty(notes = "Booleano de Produto")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    @ApiModelProperty(notes = "Código de barras do Produto")
    @Column(name = "codigo_de_barras")
    private Integer codigoDeBarras;

    @ApiModelProperty(notes = "Nome do Produto/Descricao")
    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @ApiModelProperty(notes = "Tipo de item do produto")
    @Column(name="tipo_item")
    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "Tipo de unidade do produto")
    @JoinColumn(name = "tipo_unidade_id", nullable = false)
    private Unidade unidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "Tipo de categoria do produto")
    @JoinColumn(name = "produto_id")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "Marca de Produtos")
    @JoinColumn(name = "id_marca_produto")
    private Marca marca;

    @ApiModelProperty(notes = "Modelo de Produtos")
    @Column(name = "modelo_produto")
    private String modelo;

}
