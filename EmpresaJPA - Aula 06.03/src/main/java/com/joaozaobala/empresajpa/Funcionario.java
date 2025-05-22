package com.joaozaobala.empresajpa;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Funcionario {
    @Id
    private String cpf;
    @Embedded
    private Nome nome;
    private Date dataNascimento;
    private String sexo;
    private String salario;
    private String endereco;

    //auto relaionamento SUPERVISIONA
    @ManyToOne
    @JoinColumn(name = "supervisor_cpf")
    private Funcionario supervisor;
    @OneToMany (mappedBy = "supervisor")
    private List<Funcionario> supervisionados;


    //Um funcionario tem varios dependentes
    @OneToMany (mappedBy = "parentesco")
    private List<Dependente> dependentes;

    //Relacao TRABALHA_PARA: muitos trabalham para um departamento
    @ManyToOne //muitos funcionarios se relacionam em um departamento
    @JoinColumn(name = "Dnr")
    private Departamento dpe;

    //Relacao TRABALHA_EM : entre funcionario e projeto
    @OneToMany (mappedBy = "cpfFuncionario") //mapeia da tabela FuncionarioProjeto
    private List<TrabalhaEm> listaProjetosF;

    //Relacao GERENCIA
    @OneToOne (mappedBy = "gerente")
    private Departamento gerente_departamento;


}
