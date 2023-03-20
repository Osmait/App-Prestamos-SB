package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.TransactionCreator;
import com.Prestamos.PrestamosSB.application.find.FindTransaction;
import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.infraestruture.Dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private  final FindTransaction findTransaction;

    private final TransactionCreator transactionCreator;



    @PostMapping("/transaction")
    public ResponseEntity<HttpStatus>createTransactions(@RequestBody TransactionDto request){
        Transaction transaction =  request.getTransactionFromDto();
        transactionCreator.create(transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<List<Transaction>>getTransactionByLoanId(@PathVariable Long id){
        return ResponseEntity.ok().body(findTransaction.findAllTransaction(id));


    }


}
