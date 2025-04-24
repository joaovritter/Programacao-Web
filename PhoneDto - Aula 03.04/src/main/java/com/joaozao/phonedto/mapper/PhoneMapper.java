package com.joaozao.phonedto.mapper;

import com.joaozao.phonedto.dto.PhoneRequestDTO;
import com.joaozao.phonedto.dto.PhoneResponseDTO;
import com.joaozao.phonedto.model.Phone;
import com.joaozao.phonedto.model.User;

/**
 * Classe responsável por realizar o mapeamento entre DTOs e a entidade Phone.
 * Segue o padrão de projeto Mapper para manter a separação de responsabilidades.
 */
public class PhoneMapper {

    private PhoneMapper() {
        // Construtor privado para evitar instanciação
    }

    /**
     * Converte um PhoneRequestDTO em uma entidade Phone.
     *
     * @param dto DTO com os dados do telefone
     * @param user Usuário dono do telefone
     * @return Entidade Phone com os dados do DTO
     */
    public static Phone toEntity(PhoneRequestDTO dto, User user) {
        Phone phone = new Phone();
        phone.setNumber(dto.getNumber());
        phone.setUser(user);
        return phone;
    }

    /**
     * Converte uma entidade Phone em um PhoneResponseDTO.
     *
     * @param phone Entidade Phone
     * @return DTO com os dados do telefone
     */
    public static PhoneResponseDTO toDTO(Phone phone) {
        PhoneResponseDTO dto = new PhoneResponseDTO();
        dto.setId(phone.getId());
        dto.setNumber(phone.getNumber());
        return dto;
    }
} 