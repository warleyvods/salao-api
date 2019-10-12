package com.nailshair.salao.api.pessoa.controller;

import com.nailshair.salao.api.pessoa.entity.Pessoa;
import com.nailshair.salao.api.pessoa.repository.PessoaRepository;
import com.nailshair.salao.api.pessoa.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Controller Responsável por Pessoas
 *
 * @author Warley Vinicius
 * @since 12/10/2019
 */
@Api(tags="Pessoas Controller")
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaRepository pessoaRepository;
    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaRepository pessoaRepository, PessoaService pessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaService = pessoaService;
    }

    /**
     * Cria uma nova pessoa
     *
     * @param pessoa a ser preenchida e salva
     * @return pessoa salva com status 200
     */
    @PostMapping
    @ApiOperation(value = "Adicionar Nova Pessoa")
    public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    /**
     * Realiza a busca  de todas as pessoas listando-as
     *
     * @return Lista de pessoas com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Pessoas")
    public ResponseEntity<?> listarPessoa() {
        return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de pessoas por id
     *
     * @param id a ser pesquisado
     * @return Pessoa que foi buscada por id
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar Pessoa por Código")
    public ResponseEntity<Pessoa> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Pessoa pessoa = pessoaService.buscarPessoaPorId(id);
        return pessoa != null ? new ResponseEntity<>(pessoa, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Pessoa informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar pessoa por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPessoas(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        pessoaRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade pessoa.
     *
     * @param id id a ser atualizado
     * @param pessoa body pessoa preenchida para a atualização
     * @return pessoa atualizada com status 200
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar pessoa por Id")
    public ResponseEntity<Pessoa> atualizarPessoas(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaService.atualizarPessoa(id, pessoa);
        return new ResponseEntity<>(pessoaSalva, HttpStatus.OK);
    }

    /**
     *  Realiza a busca das Pessoas por nome ignorando letras maiusculas ou minusculas
     *
     * @param nome nome a ser preenchido
     * @return entidade Pessoa encontrada
     */
    @GetMapping("/buscar-por-nome/{nome}")
    @ApiOperation(value = "Buscar Pessoa por Nome Ignorando Case Sensitive")
    public ResponseEntity<?> buscarPeloNome(@ApiParam(value = "Nome para pesquisa") @PathVariable String nome) {
        pessoaRepository.findByNomeIgnoreCaseContaining(nome);
        return new ResponseEntity<>(pessoaRepository.findByNomeIgnoreCaseContaining(nome), HttpStatus.OK);
    }

}
