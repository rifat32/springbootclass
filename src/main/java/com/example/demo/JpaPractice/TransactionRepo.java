package com.example.demo.JpaPractice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {

    @Query(value ="select  * from transaction WHERE id = :transactionId",nativeQuery = true)
    List<Transaction> getAnyTransactionByID(@Param("transactionId") Integer id);


    @Query(value ="select  * from transaction WHERE payment_type = :paymentType",nativeQuery = true)
    List<Transaction> getAnyTransactionByPayment_type(@Param("paymentType") String paymentType);



    @Query(value ="select  * from transaction WHERE amount BETWEEN  :first AND :second",nativeQuery = true)
    List<Transaction> getAnyTransactionByAmount(@Param("first") Double first, @Param("second") Double second);


 List<Transaction> findByAmountBetween(Double amount1,Double amount2);

//   List<Transaction> findByPaymentTypeIgnoreCase(String type);
//    List<Transaction> findByPayment_typeAndAmountBetween(String type,Double amount1,Double amount2);

}
