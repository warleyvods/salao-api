package com.nailshair.salao.api.catalogo.categoria.service;

import com.nailshair.salao.api.catalogo.categoria.entity.Categoria;
import com.nailshair.salao.api.catalogo.categoria.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CategoriaService {
    
    @Autowired
    EntityManager entityManager;

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    /**
     * Atualiza e persiste a mercadoria
     *
     * @param id id a ser informado da mercadoria que será atualizada
     * @param categoria mercadoria a ser atualizada
     * @return mercadoria atualizada
     */
    public Categoria atualizarCategoria(Long id, Categoria categoria) {
        Categoria categoriaSalvo = buscarCategoriaPorId(id);
        BeanUtils.copyProperties(categoria, categoriaSalvo, "id");
        return categoriaRepository.save(categoriaSalvo);
    }

    /**
     * Busca mercadoria por id
     *
     * @param id id que será pesquisado
     * @return mercadoria por id
     */
    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findOne(id);
    }

    public List<Categoria> buscarCategoriaPorNome(String nome){
        Query query = entityManager.createQuery("FROM Categoria p where p.categoria.nome = :categoria");
        query.setParameter("categoria", nome);
        return query.getResultList();
    }
    
}
