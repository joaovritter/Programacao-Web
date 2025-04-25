package com.joaozao.avaliacao1registrodevendas.service;

import com.joaozao.avaliacao1registrodevendas.dto.ProdutoDTO;
import com.joaozao.avaliacao1registrodevendas.model.Produto;
import com.joaozao.avaliacao1registrodevendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoDTO createProduct(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setName(produtoDTO.getName());
        produto.setPrice(produtoDTO.getPrice());

        Produto savedProduto = produtoRepository.save(produto);
        
        return new ProdutoDTO(
            savedProduto.getId(),
            savedProduto.getName(),
            savedProduto.getPrice()
        );
    }

    public List<ProdutoDTO> findAllProducts() {
        return produtoRepository.findAll().stream()
            .map(produto -> new ProdutoDTO(
                produto.getId(),
                produto.getName(),
                produto.getPrice()
            ))
            .collect(Collectors.toList());
    }

    public ProdutoDTO findById(Long id) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        return new ProdutoDTO(
            produto.getId(),
            produto.getName(),
            produto.getPrice()
        );
    }

    public List<ProdutoDTO> findByName(String name) {
        return produtoRepository.findByNameContaining(name).stream()
            .map(produto -> new ProdutoDTO(
                produto.getId(),
                produto.getName(),
                produto.getPrice()
            ))
            .toList();
    }

    @Transactional
    public ProdutoDTO updateProduct(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setName(produtoDTO.getName());
        produto.setPrice(produtoDTO.getPrice());

        Produto updatedProduto = produtoRepository.save(produto);
        
        return new ProdutoDTO(
            updatedProduto.getId(),
            updatedProduto.getName(),
            updatedProduto.getPrice()
        );
    }

    @Transactional
    public void deleteProduct(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }
} 