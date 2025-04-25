package com.joaozao.avaliacao1registrodevendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendaResponseDTO {
    private Long productId;
    private String productName;
    private Integer quantity;
    private Float unitPrice;
    private Float subTotal;
} 