package com.nailshair.salao.api.catalogo.categoria.controller;

import com.nailshair.salao.api.catalogo.categoria.entity.Categoria;
import com.nailshair.salao.api.catalogo.categoria.repository.CategoriaRepository;
import com.nailshair.salao.api.catalogo.categoria.service.CategoriaService;
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


@Api(tags="Categoria Controller")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaRepository categoriaRepository, CategoriaService categoriaService) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaService = categoriaService;
    }
    /**
     * Cria uma nova categoria
     *
     * @param categoria a ser preenchida e salva
     * @return categoria salva com status 200
     */
    @PostMapping
    @Transactional
    @ApiOperation(value = "Adicionar Nova Categoria")
    public ResponseEntity<Categoria> criarCategoria(@Valid @RequestBody Categoria categoria) {
        Categoria categoriaSalvo = categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalvo);
    }

    /**
     * Realiza a busca  de todas as categorias listando-as
     *
     * @return Lista de categorias com status 200
     */
    @GetMapping
    @ApiOperation(value = "Listar todas as Categorias")
    public ResponseEntity<List<Categoria>> listarCategoria() {
        return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Realiza a busca de categorias por id
     *
     * @param id a ser pesquisado
     * @return Categoria que foi buscada por id
     */
    @GetMapping("{id}")
    @ApiOperation(value = "Buscar Categoria por Código")
    public ResponseEntity<Categoria> buscarPeloCodigo(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        return categoria != null ? new ResponseEntity<>(categoria, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Deleta a Categoria informada por Id
     *
     * @param id id a ser deletado
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Deletar categoria por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCategorias(@ApiParam(value = "Id de busca") @PathVariable Long id) {
        categoriaRepository.delete(id);
    }

    /**
     * Realiza a atualização de dados da Entidade categoria.
     *
     * @param id id a ser atualizado
     * @param categoria body categoria preenchida para a atualização
     * @return categoria atualizada com status 200
     */
    @PutMapping("{id}")
    @ApiOperation(value = "Atualizar categoria por Id")
    public ResponseEntity<Categoria> atualizarCategorias(@ApiParam(value = "Id de busca") @PathVariable Long id, @Valid @RequestBody Categoria categoria) {
        Categoria categoriaSalva = categoriaService.atualizarCategoria(id, categoria);
        return new ResponseEntity<>(categoriaSalva, HttpStatus.OK);
    }
    
}
