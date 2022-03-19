package com.example.demo.JpaPractice;

import java.util.ArrayList;
import java.util.List;

public class ListSeparate {
    public String message;
    public List<Transaction> TransactionList;
    public ListSeparate(String message,List<Transaction> TransactionList) {
        this.message = message;
        this.TransactionList = TransactionList;

    }
    public Object get(){
        return this;
    }

}
