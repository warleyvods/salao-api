package com.nailshair.salao.api.catalogo.estoque.service;

import com.nailshair.salao.api.catalogo.estoque.entity.Estoque;
import com.nailshair.salao.api.catalogo.estoque.repository.EstoqueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Service de Mercadoria
 * @author Warley Vinicius
 * @since 13/10/2019
 */
@Service
public class EstoqueService {

    @Autowired
    EntityManager entityManager;


    private final EstoqueRepository estoqueRepository;

    @Autowired
    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    /**
     * Atualiza e persiste a mercadoria
     *
     * @param id id a ser informado da mercadoria que será atualizada
     * @param estoque mercadoria a ser atualizada
     * @return mercadoria atualizada
     */
    public Estoque atualizarMercadoria(Long id, Estoque estoque) {
        Estoque estoqueSalvaa = buscarMercadoriaPorId(id);
        BeanUtils.copyProperties(estoque, estoqueSalvaa, "id");
        return estoqueRepository.save(estoqueSalvaa);
    }

    /**
     * Busca mercadoria por id
     *
     * @param id id que será pesquisado
     * @return mercadoria por id
     */
    public Estoque buscarMercadoriaPorId(Long id) {
       return estoqueRepository.findOne(id);
    }

    public List<Estoque> buscarMercadoriaPorNome (String nome){
        Query query = entityManager.createQuery("FROM Mercadoria m where m.produto.nome = :produto");
        query.setParameter("produto", nome);
        return query.getResultList();
    }

}
