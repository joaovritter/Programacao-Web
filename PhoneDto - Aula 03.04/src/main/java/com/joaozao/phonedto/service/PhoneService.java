package com.joaozao.phonedto.service;

import com.joaozao.phonedto.dto.PhoneRequestDTO;
import com.joaozao.phonedto.dto.PhoneResponseDTO;
import com.joaozao.phonedto.mapper.PhoneMapper;
import com.joaozao.phonedto.model.Phone;
import com.joaozao.phonedto.model.User;
import com.joaozao.phonedto.repository.PhoneRepository;
import com.joaozao.phonedto.repository.UserRepository;
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

    private PhoneMapper phoneMapper;


    public PhoneResponseDTO createPhone(Long userId, PhoneRequestDTO phoneRequestDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Phone phone = new Phone(user, phoneRequestDTO.getNumero());
        Phone savedPhone = phoneRepository.save(phone);
        return phoneMapper.convertToResponseDTO(savedPhone);
    }

    public List<PhoneResponseDTO> getAllPhonesByUserId(Long userId) {
        return phoneRepository.findByUserId(userId).stream()
                .map(p -> phoneMapper.convertToResponseDTO(p))
                .collect(Collectors.toList());
    }

    public PhoneResponseDTO getPhoneById(Long id) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
        return phoneMapper.convertToResponseDTO(phone);
    }

    public PhoneResponseDTO updatePhone(Long id, PhoneRequestDTO phoneRequestDTO) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));

        phone.setNumero(phoneRequestDTO.getNumero());
        Phone updatedPhone = phoneRepository.save(phone);
        return phoneMapper.convertToResponseDTO(updatedPhone);
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }
    }
