package com.joaozaobala.springjpa0603;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Entity
@Table (name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @Embedded //possui um objeto incorporado
    private Address address; //esse objeto vai ser uma coluna da tabela employee
}
