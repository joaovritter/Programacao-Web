package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/save")
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }

}
