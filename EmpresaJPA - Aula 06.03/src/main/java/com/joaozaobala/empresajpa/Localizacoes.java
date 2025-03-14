package com.joaozaobala.empresajpa;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Localizacoes {
    @EmbeddedId
    private LocalizacaoId idLocalizacao; //chave primaria composta

    @ManyToOne
    @MapsId ("dNumero")
    @JoinColumn (name ="dnumero")
    private Departamento departamento;


}
