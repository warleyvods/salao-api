package com.nailshair.salao.api.configuracao.empresa.funcionario.controller;

import com.nailshair.salao.api.configuracao.empresa.funcionario.entity.Funcionario;
import com.nailshair.salao.api.configuracao.empresa.funcionario.repository.FuncionarioRepository;
import com.nailshair.salao.api.configuracao.empresa.funcionario.service.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api(tags="Funcionarios Controller")
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioRepository funcionarioRepository, FuncionarioService funcionarioService) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioService = funcionarioService;
    }
    /**
     * Cria uma nova mercadoriaa
     *
     * @param funcionario a ser preenchida e salva
     * @return mercadoria salva com status 200
     */
    @PostMapping
    @Transactional
    @ApiOperation(value = "Adicionar Nova Funcionario")
    public ResponseEntity<Funcionario> criarFuncionario(@Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
    }

    /**
     * Realiza a busca  de todas as mercadorias listando-as
     *
     * @return Lista de mercadorias com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Funcionarios")
    public ResponseEntity<?> listarFuncionario() {
        return new ResponseEntity<>(funcionarioRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de mercadorias por id
     *
     * @param id a ser pesquisado
     * @return Funcionario que foi buscada por id
     */
    @GetMapping("{id}")
    @ApiOperation(value = "Buscar Funcionario por Código")
    public ResponseEntity<Funcionario> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        return funcionario != null ? new ResponseEntity<>(funcionario, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Funcionario informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar funcionario por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerFuncionarios(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        funcionarioRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade mercadoria.
     *
     * @param id id a ser atualizado
     * @param funcionario body mercadoria preenchida para a atualização
     * @return mercadoria atualizada com status 200
     */
    @PutMapping("{id}")
    @ApiOperation(value = "Atualizar funcionario por Id")
    public ResponseEntity<Funcionario> atualizarFuncionarios(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalva = funcionarioService.atualizarFuncionario(id, funcionario);
        return new ResponseEntity<>(funcionarioSalva, HttpStatus.OK);
    }
}
