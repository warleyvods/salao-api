package com.nailshair.salao.api.mercadoria.controller;

import com.nailshair.salao.api.mercadoria.entity.Mercadoria;
import com.nailshair.salao.api.mercadoria.repository.MercadoriaRepository;
import com.nailshair.salao.api.mercadoria.service.MercadoriaService;
import com.nailshair.salao.api.produto.entity.Produto;
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
@RequestMapping("/mercadorias")
public class MercadoriaController {

    private final MercadoriaRepository mercadoriaRepository;
    private final MercadoriaService mercadoriaService;

    @Autowired
    public MercadoriaController(MercadoriaRepository mercadoriaRepository, MercadoriaService mercadoriaService) {
        this.mercadoriaRepository = mercadoriaRepository;
        this.mercadoriaService = mercadoriaService;
    }

    /**
     * Cria uma nova mercadoriaa
     *
     * @param mercadoria a ser preenchida e salva
     * @return mercadoria salva com status 200
     */
    @PostMapping
    @ApiOperation(value = "Adicionar Nova Mercadoria")
    public ResponseEntity<Mercadoria> criarMercadoria(@Valid @RequestBody Mercadoria mercadoria) {
        Mercadoria mercadoriaSalva = mercadoriaRepository.save(mercadoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(mercadoriaSalva);
    }

    /**
     * Realiza a busca  de todas as mercadorias listando-as
     *
     * @return Lista de mercadorias com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Mercadorias")
    public ResponseEntity<?> listarMercadoria() {
        return new ResponseEntity<>(mercadoriaRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de mercadorias por id
     *
     * @param id a ser pesquisado
     * @return Mercadoria que foi buscada por id
     */
    @GetMapping("/mercadorias/{id}")
    @ApiOperation(value = "Buscar Mercadoria por Código")
    public ResponseEntity<Mercadoria> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Mercadoria mercadoria = mercadoriaService.buscarMercadoriaPorId(id);
        return mercadoria != null ? new ResponseEntity<>(mercadoria, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Mercadoria informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("/mercadorias/{id}")
    @ApiOperation(value = "Deletar mercadoria por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerMercadorias(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        mercadoriaRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade mercadoria.
     *
     * @param id id a ser atualizado
     * @param mercadoria body mercadoria preenchida para a atualização
     * @return mercadoria atualizada com status 200
     */
    @PutMapping("/mercadorias/{id}")
    @ApiOperation(value = "Atualizar mercadoria por Id")
    public ResponseEntity<Mercadoria> atualizarMercadorias(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Mercadoria mercadoria) {
        Mercadoria mercadoriaSalva = mercadoriaService.atualizarMercadoria(id, mercadoria);
        return new ResponseEntity<>(mercadoriaSalva, HttpStatus.OK);
    }

    /**
     *  Realiza a busca das Mercadorias por nome ignorando letras maiusculas ou minusculas
     *
     * @param mercadoria nome a ser preenchido
     * @return entidade Mercadoria encontrada
     */
   /* @GetMapping("/mercadorias/buscar-por-nome/{mercadorias}")
    @ApiOperation(value = "Buscar Mercadoria por Nome Ignorando Case Sensitive")
    public ResponseEntity<?> buscarPeloNome(@ApiParam(value = "Nome para pesquisa") @PathVariable Produto produto) {
        mercadoriaRepository.findByNomeIgnoreCaseContaining(produto);
        return new ResponseEntity<>(mercadoriaRepository.findByNomeIgnoreCaseContaining(produto), HttpStatus.OK);
    }*/

}
