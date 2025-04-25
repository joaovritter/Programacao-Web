package com.joaozao.avaliacao1registrodevendas.controller;

import com.joaozao.avaliacao1registrodevendas.dto.ClienteResponseDTO;
import com.joaozao.avaliacao1registrodevendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> createCliente(@RequestBody ClienteResponseDTO clienteDTO) {
        ClienteResponseDTO createdCliente = clienteService.createCliente(clienteDTO);
        return ResponseEntity.ok(createdCliente);
    }
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> findAllClientes() {
        List<ClienteResponseDTO> clientes = clienteService.findAllClientes();
        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable Long id) {
        ClienteResponseDTO cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClienteResponseDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteResponseDTO clienteDTO) {
        ClienteResponseDTO updatedCliente = clienteService.updateCliente(id, clienteDTO);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
