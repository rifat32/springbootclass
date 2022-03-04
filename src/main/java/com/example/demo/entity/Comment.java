package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer id;

    private Integer p_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;




}
