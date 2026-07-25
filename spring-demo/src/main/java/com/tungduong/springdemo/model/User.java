package com.tungduong.springdemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private String name;
    private String email;
    private String address;


    public User(){}

    public User(Long id, String name,String password,String email, String address) {
        this.id = id;
        this.password = password;
        this.address = address;
        this.email = email;
        this.name = name;
    }

}
