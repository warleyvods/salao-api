package com.nailshair.salao.api.catalogo.marca.controller;

import com.nailshair.salao.api.catalogo.marca.entity.Marca;
import com.nailshair.salao.api.catalogo.marca.repository.MarcaRepository;
import com.nailshair.salao.api.catalogo.marca.service.MarcaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api(tags="Marcas Controller")
@RestController
@RequestMapping("/marcas")
public class MarcaController {


    private final MarcaRepository marcaRepository;
    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaRepository marcaRepository, MarcaService marcaService) {
        this.marcaRepository = marcaRepository;
        this.marcaService = marcaService;
    }
    /**
     * Cria uma nova mercadoriaa
     *
     * @param marca a ser preenchida e salva
     * @return mercadoria salva com status 200
     */
    @PostMapping
    @Transactional
    @ApiOperation(value = "Adicionar Nova Marca")
    public ResponseEntity<Marca> criarMarca(@Valid @RequestBody Marca marca) {
        Marca marcaSalvo = marcaRepository.save(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaSalvo);
    }

    /**
     * Realiza a busca  de todas as mercadorias listando-as
     *
     * @return Lista de mercadorias com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Marcas")
    public ResponseEntity<?> listarMarca() {
        return new ResponseEntity<>(marcaRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de mercadorias por id
     *
     * @param id a ser pesquisado
     * @return Marca que foi buscada por id
     */
    @GetMapping("{id}")
    @ApiOperation(value = "Buscar Marca por Código")
    public ResponseEntity<Marca> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Marca marca = marcaService.buscarMarcaPorId(id);
        return marca != null ? new ResponseEntity<>(marca, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Marca informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar marca por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerMarcas(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        marcaRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade mercadoria.
     *
     * @param id id a ser atualizado
     * @param marca body mercadoria preenchida para a atualização
     * @return mercadoria atualizada com status 200
     */
    @PutMapping("{id}")
    @ApiOperation(value = "Atualizar marca por Id")
    public ResponseEntity<Marca> atualizarMarcas(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Marca marca) {
        Marca marcaSalva = marcaService.atualizarMarca(id, marca);
        return new ResponseEntity<>(marcaSalva, HttpStatus.OK);
    }


}
