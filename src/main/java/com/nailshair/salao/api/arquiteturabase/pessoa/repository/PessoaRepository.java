package com.nailshair.salao.api.arquiteturabase.pessoa.repository;

import com.nailshair.salao.api.arquiteturabase.pessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNomeIgnoreCaseContaining(String nome);
}
