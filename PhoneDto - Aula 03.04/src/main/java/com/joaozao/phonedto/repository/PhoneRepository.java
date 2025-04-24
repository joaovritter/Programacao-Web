package com.joaozao.phonedto.repository;

import com.joaozao.phonedto.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}