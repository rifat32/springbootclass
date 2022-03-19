package com.example.demo.JpaPractice;

import java.util.ArrayList;
import java.util.List;

public class TransactionList {



  public    List<Transaction> AllTransaction = new ArrayList<>();

public TransactionList() {
    AllTransaction.add(new Transaction("bhalo","cash",1.2,true));
    AllTransaction.add(new Transaction("bhalo","cash",1.2,true));
    AllTransaction.add(new Transaction("bhalo","cash",35.2,false));
    AllTransaction.add(new Transaction("kharap","cash",80.2,true));
    AllTransaction.add(new Transaction("bhalo","nagad",88.2,false));
    AllTransaction.add(new Transaction("bhalo","rocked",99.2,true));
    AllTransaction.add(new Transaction("bhalo","bkash",5.2,true));
    AllTransaction.add(new Transaction("bhalo","cash",56.9,false));
    AllTransaction.add(new Transaction("bhalo","cash",165.2,true));
    AllTransaction.add(new Transaction("bhalo","cash",18.2,true));
    AllTransaction.add(new Transaction("bhalo","cash",1856.2,true));
    AllTransaction.add(new Transaction("bhalo","cash",186.2,true));
    AllTransaction.add(new Transaction("bhalo","cash",186.2,true));
}

    public  List<Transaction> get() {



        return this.AllTransaction;
    }



}
