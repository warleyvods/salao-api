package com.nailshair.salao.api.mercadoria.service;

import com.nailshair.salao.api.mercadoria.entity.Mercadoria;
import com.nailshair.salao.api.mercadoria.repository.MercadoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service de Mercadoria
 * @author Warley Vinicius
 * @since 13/10/2019
 */
@Service
public class MercadoriaService {

    private final MercadoriaRepository mercadoriaRepository;

    @Autowired
    public MercadoriaService(MercadoriaRepository mercadoriaRepository) {
        this.mercadoriaRepository = mercadoriaRepository;
    }

    /**
     * Atualiza e persiste a mercadoria
     *
     * @param id id a ser informado da mercadoria que será atualizada
     * @param mercadoria mercadoria a ser atualizada
     * @return mercadoria atualizada
     */
    public Mercadoria atualizarMercadoria(Long id, Mercadoria mercadoria) {
        Mercadoria mercadoriaSalvaa = buscarMercadoriaPorId(id);
        BeanUtils.copyProperties(mercadoria, mercadoriaSalvaa, "id");
        return mercadoriaRepository.save(mercadoriaSalvaa);
    }

    /**
     * Busca mercadoria por id
     *
     * @param id id que será pesquisado
     * @return mercadoria por id
     */
    public Mercadoria buscarMercadoriaPorId(Long id) {
       return mercadoriaRepository.findOne(id);
    }

}
