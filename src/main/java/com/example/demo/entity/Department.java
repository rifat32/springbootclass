package com.example.demo.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer id;
    private  String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students;

}
