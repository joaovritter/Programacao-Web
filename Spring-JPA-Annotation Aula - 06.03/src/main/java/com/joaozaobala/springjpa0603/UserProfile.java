package com.joaozaobala.springjpa0603;

import jakarta.persistence.*;

@Entity
@Table (name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name= "first_name")
    private String firstName;
    @Column (name= "last_name")
    private String lastName;
    private String email;

    @OneToOne
    @JoinColumn (name = "user_id",unique = true)//chave estrangeira
    private User user;


}
