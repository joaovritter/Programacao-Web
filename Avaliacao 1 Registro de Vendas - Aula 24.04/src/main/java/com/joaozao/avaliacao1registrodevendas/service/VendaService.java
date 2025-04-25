package com.joaozao.avaliacao1registrodevendas.service;

import com.joaozao.avaliacao1registrodevendas.dto.*;
import com.joaozao.avaliacao1registrodevendas.model.*;
import com.joaozao.avaliacao1registrodevendas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Transactional
    public VendaResponseDTO createVenda(CreateVendaDTO createVendaDTO) {
        // Busca o cliente
        Cliente cliente = clienteRepository.findById(createVendaDTO.getClientId())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Cria a venda
        Venda venda = new Venda();
        venda.setClienteId(cliente);
        venda.setDiscount(createVendaDTO.getDiscount());

        // Calcula o total
        Float total = 0f;
        List<ItemVenda> itens = new ArrayList<>();

        for (CreateItemVendaDTO itemDTO : createVendaDTO.getItens()) {
            // Busca o produto
            Produto produto = produtoRepository.findById(itemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            // Cria o item
            ItemVenda item = new ItemVenda();
            item.setVenda(venda);
            item.setProduct(produto);
            item.setQuantity(itemDTO.getQuantity());
            item.setUnitPrice(produto.getPrice());
            item.setSubTotal(itemDTO.getQuantity() * produto.getPrice());

            itens.add(item);
            total += item.getSubTotal();
        }

        // Aplica o desconto
        if (venda.getDiscount() > 0) {
            total = total * (1 - venda.getDiscount() / 100);
        }
        venda.setTotalValue(total);

        // Salva a venda e itens
        Venda savedVenda = vendaRepository.save(venda);
        itemVendaRepository.saveAll(itens);

        // DTO -> Entity
        List<ItemVendaResponseDTO> itensResponse = itens.stream()
            .map(item -> new ItemVendaResponseDTO(
                item.getProduct().getId(),
                item.getProduct().getName(),
                item.getQuantity(),
                item.getUnitPrice(),
                item.getSubTotal()
            ))
            .toList();

        return new VendaResponseDTO(
            savedVenda.getId(),
            new ClienteResponseDTO(
                cliente.getId(),
                cliente.getName(),
                cliente.getCpf(),
                cliente.getEmail()
            ),
            itensResponse,
            savedVenda.getDiscount(),
            savedVenda.getTotalValue()
        );
    }

    public List<VendaResponseDTO> getVendas() {
        List<Venda> vendas = vendaRepository.findAll();
        List<VendaResponseDTO> response = new ArrayList<>();

        for (Venda venda : vendas) {
            List<ItemVendaResponseDTO> itensResponse = new ArrayList<>();
            for (ItemVenda item : venda.getItens()) {
                itensResponse.add(new ItemVendaResponseDTO(
                    item.getProduct().getId(),
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getUnitPrice(),
                    item.getSubTotal()
                ));
            }

            response.add(new VendaResponseDTO(
                venda.getId(),
                new ClienteResponseDTO(
                    venda.getClienteId().getId(),
                    venda.getClienteId().getName(),
                    venda.getClienteId().getCpf(),
                    venda.getClienteId().getEmail()
                ),
                itensResponse,
                venda.getDiscount(),
                venda.getTotalValue()
            ));
        }

        return response;
    }
} 