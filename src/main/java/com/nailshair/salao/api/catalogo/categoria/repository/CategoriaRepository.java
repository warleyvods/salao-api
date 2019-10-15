package com.nailshair.salao.api.catalogo.categoria.repository;

import com.nailshair.salao.api.catalogo.categoria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
