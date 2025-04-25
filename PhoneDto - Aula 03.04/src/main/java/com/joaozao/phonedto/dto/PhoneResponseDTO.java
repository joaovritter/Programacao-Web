package com.joaozao.phonedto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class PhoneResponseDTO {
    private Long id;
    private String numero;

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }
}