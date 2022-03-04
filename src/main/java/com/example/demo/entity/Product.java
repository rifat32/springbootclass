package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Product  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int id;
    private String name;
    private int quantity;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
