package com.nailshair.salao.api.catalogo.unidade.repository;

import com.nailshair.salao.api.catalogo.unidade.entity.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

}
