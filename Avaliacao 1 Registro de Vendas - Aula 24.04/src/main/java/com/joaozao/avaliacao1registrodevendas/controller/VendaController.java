package com.joaozao.avaliacao1registrodevendas.controller;

import com.joaozao.avaliacao1registrodevendas.dto.CreateVendaDTO;
import com.joaozao.avaliacao1registrodevendas.dto.VendaResponseDTO;
import com.joaozao.avaliacao1registrodevendas.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<VendaResponseDTO> createVenda(@RequestBody CreateVendaDTO createVendaDTO) {
        VendaResponseDTO venda = vendaService.createVenda(createVendaDTO);
        return ResponseEntity.ok(venda);
    }

    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> getVendas() {
        List<VendaResponseDTO> vendas = vendaService.getVendas();
        return ResponseEntity.ok(vendas);
    }
} 