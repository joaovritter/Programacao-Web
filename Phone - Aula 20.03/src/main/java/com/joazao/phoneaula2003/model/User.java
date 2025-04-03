package com.joazao.phoneaula2003.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;

    public User(String name, String email, List<Phone> phones) {
        this.name = name;
        this.email = email;
        this.phones = phones;
    }

}
