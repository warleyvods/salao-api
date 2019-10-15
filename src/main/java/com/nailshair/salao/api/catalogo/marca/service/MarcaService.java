package com.nailshair.salao.api.catalogo.marca.service;

import com.nailshair.salao.api.catalogo.marca.entity.Marca;
import com.nailshair.salao.api.catalogo.marca.repository.MarcaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    EntityManager entityManager;

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    /**
     * Atualiza e persiste a mercadoria
     *
     * @param id id a ser informado da mercadoria que será atualizada
     * @param marca mercadoria a ser atualizada
     * @return mercadoria atualizada
     */
    public Marca atualizarMarca(Long id, Marca marca) {
        Marca marcaSalvo = buscarMarcaPorId(id);
        BeanUtils.copyProperties(marca, marcaSalvo, "id");
        return marcaRepository.save(marcaSalvo);
    }

    /**
     * Busca mercadoria por id
     *
     * @param id id que será pesquisado
     * @return mercadoria por id
     */
    public Marca buscarMarcaPorId(Long id) {
        return marcaRepository.findOne(id);
    }

    public List<Marca> buscarMarcaPorNome(String nome){
        Query query = entityManager.createQuery("FROM Marca p where p.marca.nome = :marca");
        query.setParameter("marca", nome);
        return query.getResultList();
    }

}
