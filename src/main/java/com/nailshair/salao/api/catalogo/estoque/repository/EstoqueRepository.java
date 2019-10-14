package com.nailshair.salao.api.catalogo.estoque.repository;

import com.nailshair.salao.api.catalogo.estoque.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {



}
