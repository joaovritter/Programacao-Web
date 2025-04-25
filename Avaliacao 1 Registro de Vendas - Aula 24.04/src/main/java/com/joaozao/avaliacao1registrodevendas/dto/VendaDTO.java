package com.joaozao.avaliacao1registrodevendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {
    private Long id;
    private Long clienteId;
    private String clienteName;
    private List<ItemVendaDTO> itens;
    private Float discount;
    private Float totalValue;
} 