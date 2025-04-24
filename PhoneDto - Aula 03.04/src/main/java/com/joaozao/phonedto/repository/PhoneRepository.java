package com.joaozao.phonedto.repository;

import com.joaozao.phonedto.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

    @Override
    Optional<Phone> findById(Long id);

    Optional<Phone> findByUserId(Long userId);
}
