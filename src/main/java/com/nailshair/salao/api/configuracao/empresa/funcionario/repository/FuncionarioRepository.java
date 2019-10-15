package com.nailshair.salao.api.configuracao.empresa.funcionario.repository;

import com.nailshair.salao.api.configuracao.empresa.funcionario.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
