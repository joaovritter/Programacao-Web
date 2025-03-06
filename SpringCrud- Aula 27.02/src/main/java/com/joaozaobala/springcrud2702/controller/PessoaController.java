package com.joaozaobala.springcrud2702.controller;

import com.joaozaobala.springcrud2702.model.Pessoa;
import com.joaozaobala.springcrud2702.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //identificando classe como controller
//ou seja, vai responder a requisições HTTP
@RequestMapping("/pessoa") //Url base para os endpoints desta classe
public class PessoaController {
    private final PessoaRepository pessoaRepository; //final: apos atribuir valores ao objeto, nao é mais modificado

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    //select * from Pessoa
    @GetMapping //getMapping mapeia requisicoes HTTP do tipo GET
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    //select * from pessoa where id
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable int id) {
        return pessoaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //select * from pessoa where cpf
    @GetMapping("/cpf/{cpf}")//responseEntity é uma classe para representar toda a resposta http
    public ResponseEntity<Pessoa> buscarPorCpf(@PathVariable String cpf) {
        return pessoaRepository.findByCpf(cpf)
                .map(ResponseEntity::ok) //se encontrar, retorna 200 OK com os dados
                .orElse(ResponseEntity.notFound().build()); //se nao encontrar, retorna 404 Not Found
    }
    //insert
    @PostMapping //metodo post( inserir pessoa no banco de dados)
    public @ResponseBody Pessoa salvar (@RequestBody Pessoa p) { //RequestBody: transforma o json recebido em um objeto pessoa
        pessoaRepository.save(p);
        return p;
    }

    //update pessoa
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar (@PathVariable int id, @RequestBody Pessoa pessoaAtualizada ) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pessoa nao encontrada com id: "+ id));

        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setCpf(pessoaAtualizada.getCpf());
        pessoa.setEmail(pessoaAtualizada.getEmail());
        pessoaRepository.save(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    //delete pessoa
    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> remover (@PathVariable int id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
