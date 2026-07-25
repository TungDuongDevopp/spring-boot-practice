package com.tungduong.springdemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter @Getter
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public Post(Long id,String title,String content,Date updatedAt,Date createdAt) {
        this.updatedAt = updatedAt;
        this.title = title;
        this.id = id;
        this.createdAt = createdAt;
        this.content = content;
    }
    public Post(){}
}
