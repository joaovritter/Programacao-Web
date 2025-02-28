package com.joaozaobala.springcrud2702.model;

import jakarta.persistence.*;


@Entity //indentifica que a classe é um model
public class Pessoa {
    @Id//indica q int id é o indentificador da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false, length = 100) // coluna nome não pode ser nula e só pode ter 100 caracteres
    private String nome;

    @Column (nullable = false, unique = true, length = 11)//coluna cpf nao é nula, unica e tem tamanho 11
    private String cpf;

    @Column (nullable = false, unique = true)// coluna email não é nula e unica
    private String email;

    public Pessoa(String nome, String cpf, String email) { //sem id pois é auto increment
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Pessoa() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
