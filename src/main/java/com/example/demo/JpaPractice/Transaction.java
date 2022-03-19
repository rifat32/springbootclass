package com.example.demo.JpaPractice;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    private Integer id;

    private String remarks;

    private String payment_type;

    private Double amount;

    private Boolean is_active;
    public Transaction(){}
    public Transaction(String remarks,String payment_type,Double amount,Boolean is_active) {
      this.remarks = remarks;
      this.payment_type = payment_type;
      this.amount = amount;
      this.is_active = is_active;
    }
}
