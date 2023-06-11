package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.TransactionCreator;
import com.Prestamos.PrestamosSB.application.find.FindLoan;
import com.Prestamos.PrestamosSB.application.find.FindTransaction;
import com.Prestamos.PrestamosSB.domain.Loan.Loan;
import com.Prestamos.PrestamosSB.domain.Transaction.Transaction;
import com.Prestamos.PrestamosSB.infraestruture.Dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TransactionController {

    private  final FindTransaction findTransaction;

    private final TransactionCreator transactionCreator;

    private final FindLoan findPrestamos;



    @PostMapping("/transaction")
    public ResponseEntity<HttpStatus>createTransactions(@RequestBody TransactionDto request) {

        Loan loan = findPrestamos.findLoanById(request.getLoanId());
        request.setLoan(loan);
        Transaction transaction =  request.getTransactionFromDto();
        transactionCreator.create(transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<List<Transaction>>getTransactionByLoanId(@PathVariable UUID id){
        return ResponseEntity.ok().body(findTransaction.findAllTransaction(id));
    }

    @GetMapping("/transaction/user")
    public ResponseEntity<List<Transaction>>getTransactionByUserId(){
        return ResponseEntity.ok().body(findTransaction.findAllTransactionbyUser());
    }
    @DeleteMapping("/transaction/{id}")
    public  ResponseEntity<HttpStatus>deleteTransaction(@PathVariable UUID id)  {
        findTransaction.findAndDeleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
