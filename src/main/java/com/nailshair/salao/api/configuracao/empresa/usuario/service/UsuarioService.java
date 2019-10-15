package com.nailshair.salao.api.configuracao.empresa.usuario.service;

import com.nailshair.salao.api.configuracao.empresa.usuario.entity.Usuario;
import com.nailshair.salao.api.configuracao.empresa.usuario.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UsuarioService {

    @Autowired
    EntityManager entityManager;

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Atualiza e persiste a mercadoria
     *
     * @param id id a ser informado da mercadoria que será atualizada
     * @param usuario mercadoria a ser atualizada
     * @return mercadoria atualizada
     */
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioSalvo = buscarUsuarioPorId(id);
        BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
        return usuarioRepository.save(usuarioSalvo);
    }

    private Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findOne(id);
    }

}
