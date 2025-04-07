package com.joazao.phoneaula2003.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    // Opção 1: Buscar por entidade User
    List<Phone> findByUser(User user);

    // Opção 2: Buscar por ID do User (recomendado para evitar carregar a entidade inteira)
    List<Phone> findByUserId(Long userId);
}