package com.joaozao.menubackend.repository;

import com.joaozao.menubackend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
