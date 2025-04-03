package com.joazao.phoneaula2003.repository;

import com.joazao.phoneaula2003.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findById(User user);
}
