package com.joaozao.phonedto.mapper;

import com.joaozao.phonedto.dto.PhoneResponseDTO;
import com.joaozao.phonedto.dto.UserResponseDTO;
import com.joaozao.phonedto.model.Phone;
import com.joaozao.phonedto.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public UserResponseDTO convertToResponseDto(User user) {
        List<PhoneResponseDTO> listPhones = user.getPhones().stream()
                .map (p -> {
                    PhoneResponseDTO phoneResponseDTO = new PhoneResponseDTO();
                    phoneResponseDTO.setId(p.getId());
                    phoneResponseDTO.setNumero(p.getNumero());
                    return phoneResponseDTO;
                })
                .toList();
        return new UserResponseDTO(user.getId(), user.getNome(), user.getEmail(), listPhones);
    }
    public User convertToEntity(UserResponseDTO userResponseDTO) {
        User user = new User();
        user.setId(userResponseDTO.getId());
        user.setNome(userResponseDTO.getNome());
        user.setEmail(userResponseDTO.getEmail());
        List<Phone> phones = new ArrayList<>();

        for (PhoneResponseDTO phoneResponseDTO : userResponseDTO.getPhones()) {
            Phone phone = new Phone();
            phone.setId(phoneResponseDTO.getId());
            phone.setNumero(phoneResponseDTO.getNumero());
            phones.add(phone);
        }
        user.setPhones(phones);

        return user;
    }

}
