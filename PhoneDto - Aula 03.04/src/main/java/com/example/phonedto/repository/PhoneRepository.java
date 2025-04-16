package com.example.phonedto.repository;

import com.example.phonedto.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

    @Override
    Optional<Phone> findById(Long id);
}
