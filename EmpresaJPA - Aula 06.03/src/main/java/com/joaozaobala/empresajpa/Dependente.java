package com.joaozaobala.empresajpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Dependente {
    @Id
    @EmbeddedId
    private DependenteId id;
    private String sexo;
    private Date dataNascimento;
    @ManyToOne
    @JoinColumn (name= "Fcpf")
    @MapsId ("funcionario_cpf")
    private Funcionario parentesco;
}
