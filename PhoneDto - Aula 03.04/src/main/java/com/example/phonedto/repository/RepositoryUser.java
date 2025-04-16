package com.example.phonedto.repository;

import com.example.phonedto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<User,Long> {

    Optional<User> findById(Long id);

}
