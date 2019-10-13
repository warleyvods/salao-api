package com.nailshair.salao.api.pessoa.repository;

import com.nailshair.salao.api.pessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de Pessoas
 *
 * @author Warley Vinicius
 * @since 13/10/2019
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNomeIgnoreCaseContaining(String nome);
}
