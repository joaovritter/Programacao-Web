package com.joaozaobala.springjpa0603;

import jakarta.persistence.*;

import java.util.List;

@Entity //é uma entidade
@Table(name = "students") //é uma tabela com o nome students
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "student_course", //muitos pra muitos = cria nova tabela
               joinColumns = @JoinColumn (name = "student_id"),
               inverseJoinColumns = @JoinColumn (name = "course_id")
    )
    private List<Course> courses;







}
