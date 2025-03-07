package com.joaozaobala.springjpa0603;

import jakarta.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private String type;
    private String areaCode;
    @ManyToOne //muitos telefones pertencem a um usuario
    @JoinColumn (name = "user_id") //chave estrangeira
    private User user;

}
