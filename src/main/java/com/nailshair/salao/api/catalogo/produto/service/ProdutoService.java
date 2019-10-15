package com.nailshair.salao.api.catalogo.produto.service;

import com.nailshair.salao.api.catalogo.produto.entity.Produto;
import com.nailshair.salao.api.catalogo.produto.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class ProdutoService {


    @Autowired
    EntityManager entityManager;

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    /**
     * Atualiza e persiste a mercadoria
     *
     * @param id id a ser informado da mercadoria que será atualizada
     * @param produto mercadoria a ser atualizada
     * @return mercadoria atualizada
     */
    public Produto atualizarProduto(Long id, Produto produto) {
        Produto produtoSalva = buscarProdutoPorId(id);
        BeanUtils.copyProperties(produto, produtoSalva, "id");
        return produtoRepository.save(produtoSalva);
    }

    /**
     * Busca mercadoria por id
     *
     * @param id id que será pesquisado
     * @return mercadoria por id
     */
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findOne(id);
    }

    public List<Produto> buscarProdutoPorNome (String nome){
        Query query = entityManager.createQuery("FROM Produto p where p.produto.nome = :produto");
        query.setParameter("produto", nome);
        return query.getResultList();
    }
    
}
