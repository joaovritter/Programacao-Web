package com.joaozaobala.empresajpa;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;

@Embeddable
public class LocalizacaoId implements Serializable {
    private String dLocal;
    private int dNumero;
}
