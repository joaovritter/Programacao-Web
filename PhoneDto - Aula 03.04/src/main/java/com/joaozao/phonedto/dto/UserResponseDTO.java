package com.joaozao.phonedto.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private List<PhoneResponseDTO> phones;
} 