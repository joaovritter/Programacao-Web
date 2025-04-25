package com.joaozao.avaliacao1registrodevendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVendaDTO {
    private Long clientId;
    private Float discount;
    private List<CreateItemVendaDTO> itens;
} 