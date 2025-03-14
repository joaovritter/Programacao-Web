package com.joaozaobala.empresajpa;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Departamento {
    @Id
    private int dnumero;
    @Column(unique=true)
    private String dnome;
    //Relacao TRABALHA_PARA: um departamento aloca muitos funcionarios
    @OneToMany (mappedBy = "dpe", cascade = CascadeType.ALL) //mapear pelo objeto que esta no Funcionario
    private List<Funcionario> listaFuncionarios;

    //@orphanRemoval: ao remover uma Localizacao da lista, será deletada automaticamente do banco.
    @OneToMany (mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Localizacoes> localizacoes;

    //Relacao GERENCIA
    @OneToOne
    @JoinColumn (name = "cpf_gerente")
    private Funcionario gerente;
    private Date data_inicio_gerente;



}
