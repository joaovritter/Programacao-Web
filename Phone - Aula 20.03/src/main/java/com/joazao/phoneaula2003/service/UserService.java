package com.joazao.phoneaula2003.service;

import com.joazao.phoneaula2003.model.Phone;
import com.joazao.phoneaula2003.model.User;
import com.joazao.phoneaula2003.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(User user) {
        user.getPhones().forEach(phone -> phone.setUser(user));
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        var user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }


}
