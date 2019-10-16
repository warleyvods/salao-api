package com.nailshair.salao.api.venda.pedido.controller;

import com.nailshair.salao.api.venda.pedido.entity.Pedido;
import com.nailshair.salao.api.venda.pedido.repository.PedidoRepository;
import com.nailshair.salao.api.venda.pedido.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags="Pedido Controller")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoRepository pedidoRepository, PedidoService pedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoService = pedidoService;
    }
    /**
     * Cria uma nova pedido
     *
     * @param pedido a ser preenchida e salva
     * @return pedido salva com status 200
     */
    @PostMapping
    @Transactional
    @ApiOperation(value = "Adicionar Nova Pedido")
    public ResponseEntity<Pedido> criarPedido(@Valid @RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    /**
     * Realiza a busca  de todas as pedidos listando-as
     *
     * @return Lista de pedidos com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Pedidos")
    public ResponseEntity<List<Pedido>> listarPedido() {
        return new ResponseEntity<>(pedidoRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de pedidos por id
     *
     * @param id a ser pesquisado
     * @return Pedido que foi buscada por id
     */
    @GetMapping("{id}")
    @ApiOperation(value = "Buscar Pedido por Código")
    public ResponseEntity<Pedido> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        return pedido != null ? new ResponseEntity<>(pedido, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Pedido informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar pedido por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPedidos(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        pedidoRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade pedido.
     *
     * @param id id a ser atualizado
     * @param pedido body pedido preenchida para a atualização
     * @return pedido atualizada com status 200
     */
    @PutMapping("{id}")
    @ApiOperation(value = "Atualizar pedido por Id")
    public ResponseEntity<Pedido> atualizarPedidos(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Pedido pedido) {
        Pedido pedidoSalva = pedidoService.atualizarPedido(id, pedido);
        return new ResponseEntity<>(pedidoSalva, HttpStatus.OK);
    }

}
