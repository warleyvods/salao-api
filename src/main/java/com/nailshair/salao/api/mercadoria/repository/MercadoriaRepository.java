package com.nailshair.salao.api.mercadoria.repository;

import com.nailshair.salao.api.mercadoria.entity.Mercadoria;
import com.nailshair.salao.api.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MercadoriaRepository extends JpaRepository<Mercadoria, Long> {


//    List<Produto> findByNomeIgnoreCaseContaining(Produto nome);

}
