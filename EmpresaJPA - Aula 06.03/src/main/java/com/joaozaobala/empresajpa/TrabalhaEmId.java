package com.joaozaobala.empresajpa;

import jakarta.persistence.*;

import java.io.Serializable;

/***
 * Classe para armazenar somente chave primária composta
 * @see  Embeddable pois a clase vai ser embutível em outra, neste caso em ColaboradorProjeto
 * @see Serializable permite uma classe ter duas chaves primárias
 */
@Embeddable
public class TrabalhaEmId implements Serializable {
    @Column (name =  "Fcpf")
    private String funcionarioCpf;
    @Column (name = "Pnr")
    private int projetoId;

}