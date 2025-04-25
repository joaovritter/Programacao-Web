package com.joaozao.avaliacao1registrodevendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemVendaDTO {
    private Long productId;
    private Integer quantity;
} 