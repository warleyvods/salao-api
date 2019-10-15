package com.nailshair.salao.api.catalogo.marca.repository;

import com.nailshair.salao.api.catalogo.marca.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {



}
