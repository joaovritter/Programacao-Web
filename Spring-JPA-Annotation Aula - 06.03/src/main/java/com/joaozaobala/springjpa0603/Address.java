package com.joaozaobala.springjpa0603;

import jakarta.persistence.Embeddable;

@Embeddable //serve para atributos multivalorados
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
}
