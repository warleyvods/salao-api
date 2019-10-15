package com.nailshair.salao.api.catalogo.servico.service;

import com.nailshair.salao.api.catalogo.servico.entity.Servico;
import com.nailshair.salao.api.catalogo.servico.repository.ServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class ServicoService {



    @Autowired
    EntityManager entityManager;

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    /**
     * Atualiza e persiste a mercadoria
     *
     * @param id id a ser informado da mercadoria que será atualizada
     * @param servico mercadoria a ser atualizada
     * @return mercadoria atualizada
     */
    public Servico atualizarServico(Long id, Servico servico) {
        Servico servicoSalvo = buscarServicoPorId(id);
        BeanUtils.copyProperties(servico, servicoSalvo, "id");
        return servicoRepository.save(servicoSalvo);
    }

    /**
     * Busca mercadoria por id
     *
     * @param id id que será pesquisado
     * @return mercadoria por id
     */
    public Servico buscarServicoPorId(Long id) {
        return servicoRepository.findOne(id);
    }

    public List<Servico> buscarServicoPorNome (String nome){
        Query query = entityManager.createQuery("FROM Servico p where p.servico.nome = :servico");
        query.setParameter("servico", nome);
        return query.getResultList();
    }


}
