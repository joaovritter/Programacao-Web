package com.joaozao.avaliacao1registrodevendas.service;

import com.joaozao.avaliacao1registrodevendas.dto.ClienteResponseDTO;
import com.joaozao.avaliacao1registrodevendas.model.Cliente;
import com.joaozao.avaliacao1registrodevendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDTO createCliente(ClienteResponseDTO clienteDTO) {
        Cliente cliente = new Cliente();

        cliente.setName(clienteDTO.getName());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());

        Cliente savedCliente = clienteRepository.save(cliente);
        
        return new ClienteResponseDTO(savedCliente.getId(), savedCliente.getName(), savedCliente.getCpf(), savedCliente.getEmail());
    }
    public List<ClienteResponseDTO> findAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> new ClienteResponseDTO(cliente.getId(), cliente.getName(), cliente.getCpf(), cliente.getEmail()))
                .toList();
    }

    public ClienteResponseDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
        return new ClienteResponseDTO(cliente.getId(), cliente.getName(), cliente.getCpf(), cliente.getEmail());
    }


    public ClienteResponseDTO updateCliente(Long id, ClienteResponseDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).get();

            cliente.setName(clienteDTO.getName());
            cliente.setCpf(clienteDTO.getCpf());
            cliente.setEmail(clienteDTO.getEmail());

            Cliente updatedCliente = clienteRepository.save(cliente);
            return new ClienteResponseDTO(updatedCliente.getId(), updatedCliente.getName(), updatedCliente.getCpf(), updatedCliente.getEmail());
    }

    public void deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente not found"));
        clienteRepository.delete(cliente);
    }
}
