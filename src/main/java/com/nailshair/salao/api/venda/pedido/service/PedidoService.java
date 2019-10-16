package com.nailshair.salao.api.venda.pedido.service;

import com.nailshair.salao.api.venda.pedido.entity.Pedido;
import com.nailshair.salao.api.venda.pedido.repository.PedidoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    EntityManager entityManager;

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    /**
     * Atualiza e persiste a pedido
     *
     * @param id id a ser informado da pedido que será atualizada
     * @param pedido pedido a ser atualizada
     * @return pedido atualizada
     */
    public Pedido atualizarPedido(Long id, Pedido pedido) {
        Pedido pedidoSalvo = buscarPedidoPorId(id);
        BeanUtils.copyProperties(pedido, pedidoSalvo, "id");
        return pedidoRepository.save(pedidoSalvo);
    }

    /**
     * Busca pedido por id
     *
     * @param id id que será pesquisado
     * @return pedido por id
     */
    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findOne(id);
    }

    public List<Pedido> buscarPedidoPorNome (String nome){
        Query query = entityManager.createQuery("FROM Pedido p where p.pedido.nome = :pedido");
        query.setParameter("pedido", nome);
        return query.getResultList();
    }

}
