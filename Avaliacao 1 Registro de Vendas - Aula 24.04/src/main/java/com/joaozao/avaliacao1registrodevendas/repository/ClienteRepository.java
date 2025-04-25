package com.joaozao.avaliacao1registrodevendas.repository;

import com.joaozao.avaliacao1registrodevendas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
} 