package com.example.phonedto.Dto;

import lombok.Data;
import java.util.List;

@Data
public class UserRequestDTO {
    private String nome;
    private String email;
    private List<PhoneRequestDTO> phones;
} 