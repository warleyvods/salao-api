package com.nailshair.salao.api.catalogo.produto.repository;

import com.nailshair.salao.api.catalogo.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
