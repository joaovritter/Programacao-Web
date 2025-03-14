package com.joaozaobala.empresajpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int projNumero;
    private String projNome;
    private String projLocal;

    @OneToMany (mappedBy = "numeroProjeto") //mapeia da clasee FuncionarioProjeto
    private List<TrabalhaEm> listaFuncionariosP;
}
