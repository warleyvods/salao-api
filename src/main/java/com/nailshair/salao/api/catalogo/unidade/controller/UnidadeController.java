package com.nailshair.salao.api.catalogo.unidade.controller;

import com.nailshair.salao.api.catalogo.unidade.entity.Unidade;
import com.nailshair.salao.api.catalogo.unidade.repository.UnidadeRepository;
import com.nailshair.salao.api.catalogo.unidade.service.UnidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api(tags="Unidade Controller")
@RestController
@RequestMapping("/unidades")
public class UnidadeController {


    private final UnidadeRepository unidadeRepository;
    private final UnidadeService unidadeService;

    @Autowired
    public UnidadeController(UnidadeRepository unidadeRepository, UnidadeService unidadeService) {
        this.unidadeRepository = unidadeRepository;
        this.unidadeService = unidadeService;
    }
    /**
     * Cria uma nova mercadoriaa
     *
     * @param unidade a ser preenchida e salva
     * @return mercadoria salva com status 200
     */
    @PostMapping
    @Transactional
    @ApiOperation(value = "Adicionar Nova Unidade")
    public ResponseEntity<Unidade> criarUnidade(@Valid @RequestBody Unidade unidade) {
        Unidade unidadeSalvo = unidadeRepository.save(unidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadeSalvo);
    }

    /**
     * Realiza a busca  de todas as mercadorias listando-as
     *
     * @return Lista de mercadorias com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Unidades")
    public ResponseEntity<?> listarUnidade() {
        return new ResponseEntity<>(unidadeRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de mercadorias por id
     *
     * @param id a ser pesquisado
     * @return Unidade que foi buscada por id
     */
    @GetMapping("{id}")
    @ApiOperation(value = "Buscar Unidade por Código")
    public ResponseEntity<Unidade> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Unidade unidade = unidadeService.buscarUnidadePorId(id);
        return unidade != null ? new ResponseEntity<>(unidade, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Unidade informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar unidade por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerUnidades(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        unidadeRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade mercadoria.
     *
     * @param id id a ser atualizado
     * @param unidade body mercadoria preenchida para a atualização
     * @return mercadoria atualizada com status 200
     */
    @PutMapping("{id}")
    @ApiOperation(value = "Atualizar unidade por Id")
    public ResponseEntity<Unidade> atualizarUnidades(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Unidade unidade) {
        Unidade unidadeSalva = unidadeService.atualizarUnidade(id, unidade);
        return new ResponseEntity<>(unidadeSalva, HttpStatus.OK);
    }


}
