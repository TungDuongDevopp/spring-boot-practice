package com.tungduong.springdemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name không được trống")
    private String name;
    @Column(length = 60)
    private String password;
    @NotBlank(message = "Email không được trống")
    private String email;
    @NotBlank(message = "Address không được trống")
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
