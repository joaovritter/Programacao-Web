package com.joaozao.avaliacao1registrodevendas.controller;

import com.joaozao.avaliacao1registrodevendas.dto.ProdutoDTO;
import com.joaozao.avaliacao1registrodevendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduct(@RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO createdProduct = produtoService.createProduct(produtoDTO);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAllProducts() {
        List<ProdutoDTO> products = produtoService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        ProdutoDTO product = produtoService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProdutoDTO>> findByName(@PathVariable String name) {
        List<ProdutoDTO> products = produtoService.findByName(name);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProdutoDTO> updateProduct(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO updatedProduct = produtoService.updateProduct(id, produtoDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        produtoService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
} 