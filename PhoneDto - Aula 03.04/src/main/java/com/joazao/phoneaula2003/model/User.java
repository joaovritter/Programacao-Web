package com.joazao.phoneaula2003.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data //getter, setter, toString, equal, hahCode, constructor
@NoArgsConstructor //construtor sem argumentos
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
