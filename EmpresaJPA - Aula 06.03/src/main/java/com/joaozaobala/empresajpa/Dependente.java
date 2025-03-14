package com.joaozaobala.empresajpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Dependente {
    @Id
    @EmbeddedId //chave primaria composta que vem do DependenteId
    private DependenteId id;
    private String sexo;
    private Date dataNascimento;

    //MapsID: A partir do parentesco ele descobre a chave estrangeira (cpf do funcionario)
    // mapeia a chave estrangeira (Fcpf) diretamente na chave primária composta (DependenteId)
    // depois ele joga o Fpf para a minha chave primaria, como ela é composta, especifico que é no funcionario_cpf
    @JoinColumn (name= "Fcpf")
    @MapsId ("funcionario_cpf")
    @ManyToOne
    private Funcionario parentesco;
}
