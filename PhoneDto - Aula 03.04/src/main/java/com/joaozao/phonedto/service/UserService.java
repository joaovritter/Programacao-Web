package com.joaozao.phonedto.service;

import com.joaozao.phonedto.dto.UserRequestDTO;
import com.joaozao.phonedto.dto.UserResponseDTO;
import com.joaozao.phonedto.mapper.UserMapper;
import com.joaozao.phonedto.model.User;
import com.joaozao.phonedto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setNome(userRequestDTO.getNome());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhones(new ArrayList<>());

        
        User savedUser = userRepository.save(user);
        return userMapper.convertToResponseDto(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(p-> userMapper.convertToResponseDto(p))
                .toList();

    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return  userMapper.convertToResponseDto(user);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        user.setNome(userRequestDTO.getNome());
        user.setEmail(userRequestDTO.getEmail());
        
        User updatedUser = userRepository.save(user);
        return  userMapper.convertToResponseDto(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
