package com.nailshair.salao.api.catalogo.unidade.service;

import com.nailshair.salao.api.catalogo.unidade.entity.Unidade;
import com.nailshair.salao.api.catalogo.unidade.repository.UnidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    EntityManager entityManager;

    private final UnidadeRepository unidadeRepository;

    @Autowired
    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    /**
     * Atualiza e persiste a mercadoria
     *
     * @param id id a ser informado da mercadoria que será atualizada
     * @param unidade mercadoria a ser atualizada
     * @return mercadoria atualizada
     */
    public Unidade atualizarUnidade(Long id, Unidade unidade) {
        Unidade unidadeSalvo = buscarUnidadePorId(id);
        BeanUtils.copyProperties(unidade, unidadeSalvo, "id");
        return unidadeRepository.save(unidadeSalvo);
    }

    /**
     * Busca mercadoria por id
     *
     * @param id id que será pesquisado
     * @return mercadoria por id
     */
    public Unidade buscarUnidadePorId(Long id) {
        return unidadeRepository.findOne(id);
    }

    public List<Unidade> buscarUnidadePorNome(String nome){
        Query query = entityManager.createQuery("FROM Unidade p where p.unidade.nome = :unidade");
        query.setParameter("unidade", nome);
        return query.getResultList();
    }
    
}
