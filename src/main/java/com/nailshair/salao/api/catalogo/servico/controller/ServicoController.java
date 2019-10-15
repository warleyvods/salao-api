package com.nailshair.salao.api.catalogo.servico.controller;


import com.nailshair.salao.api.catalogo.servico.entity.Servico;
import com.nailshair.salao.api.catalogo.servico.repository.ServicoRepository;
import com.nailshair.salao.api.catalogo.servico.service.ServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags="Servico Controller")
@RestController
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoRepository servicoRepository;
    private final ServicoService servicoService;

    @Autowired
    public ServicoController(ServicoRepository servicoRepository, ServicoService servicoService) {
        this.servicoRepository = servicoRepository;
        this.servicoService = servicoService;
    }
    /**
     * Cria uma nova mercadoriaa
     *
     * @param servico a ser preenchida e salva
     * @return mercadoria salva com status 200
     */
    @PostMapping
    @Transactional
    @ApiOperation(value = "Adicionar Nova Servico")
    public ResponseEntity<Servico> criarServico(@Valid @RequestBody Servico servico) {
        Servico servicoSalvo = servicoRepository.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoSalvo);
    }

    /**
     * Realiza a busca  de todas as mercadorias listando-as
     *
     * @return Lista de mercadorias com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Servicos")
    public ResponseEntity<?> listarServico() {
        return new ResponseEntity<>(servicoRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de mercadorias por id
     *
     * @param id a ser pesquisado
     * @return Servico que foi buscada por id
     */
    @GetMapping("{id}")
    @ApiOperation(value = "Buscar Servico por Código")
    public ResponseEntity<Servico> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Servico servico = servicoService.buscarServicoPorId(id);
        return servico != null ? new ResponseEntity<>(servico, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Servico informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar servico por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerServicos(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        servicoRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade mercadoria.
     *
     * @param id id a ser atualizado
     * @param servico body mercadoria preenchida para a atualização
     * @return mercadoria atualizada com status 200
     */
    @PutMapping("{id}")
    @ApiOperation(value = "Atualizar servico por Id")
    public ResponseEntity<Servico> atualizarServicos(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Servico servico) {
        Servico servicoSalva = servicoService.atualizarServico(id, servico);
        return new ResponseEntity<>(servicoSalva, HttpStatus.OK);
    }
}
