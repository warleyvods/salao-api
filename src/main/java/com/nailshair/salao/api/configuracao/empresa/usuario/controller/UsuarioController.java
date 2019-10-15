package com.nailshair.salao.api.configuracao.empresa.usuario.controller;

import com.nailshair.salao.api.configuracao.empresa.usuario.entity.Usuario;
import com.nailshair.salao.api.configuracao.empresa.usuario.repository.UsuarioRepository;
import com.nailshair.salao.api.configuracao.empresa.usuario.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags="Usuarios Controller")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    /**
     * Cria uma nova mercadoriaa
     *
     * @param usuario a ser preenchida e salva
     * @return mercadoria salva com status 200
     */
    @PostMapping
    @Transactional
    @ApiOperation(value = "Adicionar Nova Usuario")
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    /**
     * Realiza a busca  de todas as mercadorias listando-as
     *
     * @return Lista de mercadorias com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Usuarios")
    public ResponseEntity<?> listarUsuario() {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Deleta a Usuario informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar usuario por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerUsuarios(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        usuarioRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade mercadoria.
     *
     * @param id id a ser atualizado
     * @param usuario body mercadoria preenchida para a atualização
     * @return mercadoria atualizada com status 200
     */
    @PutMapping("{id}")
    @ApiOperation(value = "Atualizar usuario por Id")
    public ResponseEntity<Usuario> atualizarUsuarios(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalva = usuarioService.atualizarUsuario(id, usuario);
        return new ResponseEntity<>(usuarioSalva, HttpStatus.OK);
    }
}
