package com.example.crud;

import jakarta.persistence.*;

@Entity //fala para o JPA-Hibernate fazer uma tabela Pessoa no banco
public class Pessoa {
    @Id //diz para o banco que o atributo abaixo é um PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)//coluna nao pode ser nula
    private String nome;

    @Column(nullable = false, unique = true) // coluna unica e nao nula
    private String email;

    @Column(length = 15) //fone é um varchar(15)
    private String fone;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String fone) {
        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", fone='" + fone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }


}
