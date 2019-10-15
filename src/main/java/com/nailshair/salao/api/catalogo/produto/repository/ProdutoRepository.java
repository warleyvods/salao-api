package com.nailshair.salao.api.catalogo.produto.repository;

import com.nailshair.salao.api.catalogo.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeIgnoreCaseContaining(String nome);
}
