package com.tungduong.springdemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public Comment(Long id,String content,Date updatedAt,Date createdAt) {
        this.updatedAt = updatedAt;
        this.id = id;
        this.createdAt = createdAt;
        this.content = content;
    }
    public Comment(){}
}
