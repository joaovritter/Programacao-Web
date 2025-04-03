package com.joazao.phoneaula2003.repository;

import com.joazao.phoneaula2003.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
