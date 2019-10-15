package com.nailshair.salao.api.configuracao.empresa.funcionario.service;

import com.nailshair.salao.api.configuracao.empresa.funcionario.entity.Funcionario;
import com.nailshair.salao.api.configuracao.empresa.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    EntityManager entityManager;

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    /**
     * Atualiza e persiste a mercadoria
     *
     * @param id id a ser informado da mercadoria que será atualizada
     * @param funcionario mercadoria a ser atualizada
     * @return mercadoria atualizada
     */
    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        Funcionario funcionarioSalvo = buscarFuncionarioPorId(id);
        BeanUtils.copyProperties(funcionario, funcionarioSalvo, "id");
        return funcionarioRepository.save(funcionarioSalvo);
    }

    /**
     * Busca mercadoria por id
     *
     * @param id id que será pesquisado
     * @return mercadoria por id
     */
    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findOne(id);
    }

    public List<Funcionario> buscarFuncionarioPorNome(String nome){
        Query query = entityManager.createQuery("FROM Funcionario p where p.funcionario.nome = :funcionario");
        query.setParameter("funcionario", nome);
        return query.getResultList();
    }
}
