package com.example.demo.JpaPractice;


import com.example.demo.view.Response;
import com.example.demo.view.ResponseBuilder;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AllController {

    final TransactionRepo transactionRepo;


    public AllController(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;

    }

    @PostMapping("all")
    Response addAll () {
        TransactionList transactionList = new TransactionList();
        List<Transaction> updatedTransactionList = new ArrayList<Transaction>();
        for (int i = 0; i < transactionList.get().size(); i++) {
        Transaction updatedTransaction =    transactionRepo.save(transactionList.get().get(i));
            updatedTransactionList.add(updatedTransaction);
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK,"success",updatedTransactionList);
    }

    @GetMapping("get")
    Response getAll () {
        List<ListSeparate> allResult = new ArrayList<ListSeparate>();
        allResult.add(new ListSeparate("transaction by id 1",transactionRepo.getAnyTransactionByID(1)));
        allResult.add(new ListSeparate("transaction by id 2",transactionRepo.getAnyTransactionByID(2)));


        allResult.add(new ListSeparate("transaction by paymenttype bkash",transactionRepo.getAnyTransactionByPayment_type("bkash")));
        allResult.add(new ListSeparate("transaction by paymenttype rocket",transactionRepo.getAnyTransactionByPayment_type("rocked")));
        allResult.add(new ListSeparate("transaction by paymenttype nogad",transactionRepo.getAnyTransactionByPayment_type("nagad")));
        allResult.add(new ListSeparate("transaction by paymenttype cash",transactionRepo.getAnyTransactionByPayment_type("cash")));

        allResult.add(new ListSeparate("transaction by amount",transactionRepo.getAnyTransactionByAmount(1.0,999.00)));
        allResult.add(new ListSeparate("transaction by amount",transactionRepo.getAnyTransactionByAmount(100.00,999.00)));
        allResult.add(new ListSeparate("transaction by amount",transactionRepo.getAnyTransactionByAmount(200.00,999.00)));
        allResult.add(new ListSeparate("transaction by amount",transactionRepo.getAnyTransactionByAmount(1.00,2.00)));

        allResult.add(new ListSeparate("transaction by id",transactionRepo.getAnyTransactionByID(1)));


//      allResult.add(new ListSeparate("all result",transactionRepo.findAll()));
//        allResult.add(new ListSeparate("transaction paymenttype cash",transactionRepo.findByPayment_typeEquals("cash")));
//        allResult.add(new ListSeparate("transaction paymenttype cash",transactionRepo.findByPayment_typeAndAmountBetween("cash",0.1,999.0)));
     allResult.add(new ListSeparate("transaction amount",transactionRepo.findByAmountBetween(0.0,999.9)));


        return ResponseBuilder.getSuccessResponse(HttpStatus.OK,"success",allResult);
    }



}
