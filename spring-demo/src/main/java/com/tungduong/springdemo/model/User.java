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


    private String role;

    public User(){}


}
