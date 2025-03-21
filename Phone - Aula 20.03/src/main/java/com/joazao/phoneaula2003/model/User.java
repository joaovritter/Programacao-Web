package com.joazao.phoneaula2003.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data //getter, setter, toString, equal, hahCode, constructor
@NoArgsConstructor //construtor sem argumentos
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;

    public User(String name, List<Phone> phones, String email) {
        this.name = name;
        this.phones = phones;
        this.email = email;
    }




}
