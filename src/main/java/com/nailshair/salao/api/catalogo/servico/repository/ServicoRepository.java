package com.nailshair.salao.api.catalogo.servico.repository;

import com.nailshair.salao.api.catalogo.servico.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
