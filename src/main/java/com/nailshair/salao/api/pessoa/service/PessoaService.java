package com.nailshair.salao.api.pessoa.service;

import com.nailshair.salao.api.pessoa.entity.Pessoa;
import com.nailshair.salao.api.pessoa.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
        Pessoa pessoaSalva = buscarPessoaPorId(id);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
        return pessoaRepository.save(pessoaSalva);
    }

    public Pessoa buscarPessoaPorId(Long id) {
        return pessoaRepository.findOne(id);
    }

}
