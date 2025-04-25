package com.joaozao.avaliacao1registrodevendas.repository;

import com.joaozao.avaliacao1registrodevendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

} 