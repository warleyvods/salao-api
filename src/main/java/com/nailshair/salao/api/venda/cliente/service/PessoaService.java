package com.nailshair.salao.api.venda.cliente.service;

import com.nailshair.salao.api.venda.cliente.entity.Pessoa;
import com.nailshair.salao.api.venda.cliente.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service responsável por pessoas
 *
 * @author Warley Vinicius
 * @since 13/10/2019
 */
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    /**
     *
     * @param id
     * @param pessoa
     * @return
     */
    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
        Pessoa pessoaSalva = buscarPessoaPorId(id);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
        return pessoaRepository.save(pessoaSalva);
    }

    public Pessoa buscarPessoaPorId(Long id) {
        return pessoaRepository.findOne(id);
    }

}
