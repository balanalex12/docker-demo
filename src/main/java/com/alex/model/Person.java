package com.alex.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "person", schema = "docker_demo")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter

public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    private Long id;

    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
