package com.joaozao.avaliacao1registrodevendas.repository;

import com.joaozao.avaliacao1registrodevendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNameContaining(String name);
} 