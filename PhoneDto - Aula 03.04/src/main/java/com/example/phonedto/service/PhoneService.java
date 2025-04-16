package com.example.phonedto.service;

import com.example.phonedto.Dto.PhoneRequestDTO;
import com.example.phonedto.Dto.PhoneResponseDTO;
import com.example.phonedto.Phone;
import com.example.phonedto.User;
import com.example.phonedto.repository.PhoneRepository;
import com.example.phonedto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    public PhoneResponseDTO createPhone(Long userId, PhoneRequestDTO phoneRequestDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Phone phone = new Phone(user, phoneRequestDTO.getNumero());
        Phone savedPhone = phoneRepository.save(phone);
        return convertToResponseDTO(savedPhone);
    }

    public List<PhoneResponseDTO> getAllPhonesByUserId(Long userId) {
        return phoneRepository.findByUserId(userId).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public PhoneResponseDTO getPhoneById(Long id) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
        return convertToResponseDTO(phone);
    }

    public PhoneResponseDTO updatePhone(Long id, PhoneRequestDTO phoneRequestDTO) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));

        phone.setNumero(phoneRequestDTO.getNumero());
        Phone updatedPhone = phoneRepository.save(phone);
        return convertToResponseDTO(updatedPhone);
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }

    private PhoneResponseDTO convertToResponseDTO(Phone phone) {
        PhoneResponseDTO responseDTO = new PhoneResponseDTO();
        responseDTO.setId(phone.getId());
        responseDTO.setNumero(phone.getNumero());
        return responseDTO;
    }
} 