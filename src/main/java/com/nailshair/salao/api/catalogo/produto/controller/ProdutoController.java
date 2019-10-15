package com.nailshair.salao.api.catalogo.produto.controller;

import com.nailshair.salao.api.catalogo.produto.entity.Produto;
import com.nailshair.salao.api.catalogo.produto.repository.ProdutoRepository;
import com.nailshair.salao.api.catalogo.produto.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags="Produto Controller")
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository, ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
    }
    /**
     * Cria uma nova mercadoriaa
     *
     * @param produto a ser preenchida e salva
     * @return mercadoria salva com status 200
     */
    @PostMapping
    @ApiOperation(value = "Adicionar Nova Produto")
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody Produto produto) {
        Produto produtoSalvo = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    /**
     * Realiza a busca  de todas as mercadorias listando-as
     *
     * @return Lista de mercadorias com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Produtos")
    public ResponseEntity<?> listarProduto() {
        return new ResponseEntity<>(produtoRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de mercadorias por id
     *
     * @param id a ser pesquisado
     * @return Produto que foi buscada por id
     */
    @GetMapping("{id}")
    @ApiOperation(value = "Buscar Produto por Código")
    public ResponseEntity<Produto> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        return produto != null ? new ResponseEntity<>(produto, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Produto informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar produto por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerProdutos(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        produtoRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade mercadoria.
     *
     * @param id id a ser atualizado
     * @param produto body mercadoria preenchida para a atualização
     * @return mercadoria atualizada com status 200
     */
    @PutMapping("{id}")
    @ApiOperation(value = "Atualizar produto por Id")
    public ResponseEntity<Produto> atualizarProdutos(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Produto produto) {
        Produto produtoSalva = produtoService.atualizarProduto(id, produto);
        return new ResponseEntity<>(produtoSalva, HttpStatus.OK);
    }

    //TODO buscar por nome
    
    
}
