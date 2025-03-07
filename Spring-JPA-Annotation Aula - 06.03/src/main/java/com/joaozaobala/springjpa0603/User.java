package com.joaozaobala.springjpa0603;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true, nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;

    @Transient // uma coluna que nao deve ser salva no banco de dados
    private String confirmPassword;

    @OneToMany (mappedBy = "user",cascade=CascadeType.ALL)
    private List<Phone> phone;

    @OneToOne (mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval = true)
    private UserProfile profile;



}
