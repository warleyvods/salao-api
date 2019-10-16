package com.nailshair.salao.api.venda.pedido.repository;

import com.nailshair.salao.api.venda.pedido.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
