package com.joaozao.avaliacao1registrodevendas.repository;

import com.joaozao.avaliacao1registrodevendas.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

} 