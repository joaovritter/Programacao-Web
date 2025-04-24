package com.joaozao.phonedto.service;

import com.joaozao.phonedto.dto.UserRequestDTO;
import com.joaozao.phonedto.dto.UserResponseDTO;
import com.joaozao.phonedto.model.User;
import com.joaozao.phonedto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setNome(userRequestDTO.getNome());
        user.setEmail(userRequestDTO.getEmail());
        
        User savedUser = userRepository.save(user);
        return convertToResponseDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToResponseDTO(user);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        user.setNome(userRequestDTO.getNome());
        user.setEmail(userRequestDTO.getEmail());
        
        User updatedUser = userRepository.save(user);
        return convertToResponseDTO(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserResponseDTO convertToResponseDTO(User user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setNome(user.getNome());
        responseDTO.setEmail(user.getEmail());
        return responseDTO;
    }
}
