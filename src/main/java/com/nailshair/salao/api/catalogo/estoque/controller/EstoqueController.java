package com.nailshair.salao.api.catalogo.estoque.controller;

import com.nailshair.salao.api.catalogo.estoque.entity.Estoque;
import com.nailshair.salao.api.catalogo.estoque.repository.EstoqueRepository;
import com.nailshair.salao.api.catalogo.estoque.service.EstoqueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags="Mercadorias Controller")
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueRepository estoqueRepository;
    private final EstoqueService estoqueService;

    @Autowired
    public EstoqueController(EstoqueRepository estoqueRepository, EstoqueService estoqueService) {
        this.estoqueRepository = estoqueRepository;
        this.estoqueService = estoqueService;
    }

    /**
     * Cria uma nova mercadoriaa
     *
     * @param estoque a ser preenchida e salva
     * @return mercadoria salva com status 200
     */
    @PostMapping
    @ApiOperation(value = "Adicionar Nova Mercadoria")
    public ResponseEntity<Estoque> criarMercadoria(@Valid @RequestBody Estoque estoque) {
        Estoque estoqueSalvo = estoqueRepository.save(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueSalvo);
    }

    /**
     * Realiza a busca  de todas as mercadorias listando-as
     *
     * @return Lista de mercadorias com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Mercadorias")
    public ResponseEntity<?> listarEstoque() {
        return new ResponseEntity<>(estoqueRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de mercadorias por id
     *
     * @param id a ser pesquisado
     * @return Mercadoria que foi buscada por id
     */
    @GetMapping("/estoque/{id}")
    @ApiOperation(value = "Buscar Mercadoria por Código")
    public ResponseEntity<Estoque> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Estoque estoque = estoqueService.buscarMercadoriaPorId(id);
        return estoque != null ? new ResponseEntity<>(estoque, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Mercadoria informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("/estoque/{id}")
    @ApiOperation(value = "Deletar mercadoria por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerMercadorias(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        estoqueRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade mercadoria.
     *
     * @param id id a ser atualizado
     * @param estoque body mercadoria preenchida para a atualização
     * @return mercadoria atualizada com status 200
     */
    @PutMapping("/estoque/{id}")
    @ApiOperation(value = "Atualizar mercadoria por Id")
    public ResponseEntity<Estoque> atualizarMercadorias(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Estoque estoque) {
        Estoque estoqueSalva = estoqueService.atualizarMercadoria(id, estoque);
        return new ResponseEntity<>(estoqueSalva, HttpStatus.OK);
    }

}
