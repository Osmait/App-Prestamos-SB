package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.LoanCreator;
import com.Prestamos.PrestamosSB.application.create.LoanUpdate;
import com.Prestamos.PrestamosSB.application.find.FindClient;
import com.Prestamos.PrestamosSB.application.find.FindLoan;
import com.Prestamos.PrestamosSB.domain.Balance;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.Loan;
import com.Prestamos.PrestamosSB.infraestruture.Dto.LoanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoanController {

    private  final LoanCreator prestamoCreator;
    private  final FindClient findClient;

    private final FindLoan findPrestamos;
    private  final LoanUpdate loanUpdate;

    @GetMapping("/loan/{id}")
    public ResponseEntity<List<Loan>>getAllLoanByClientId(@PathVariable Long id){

        List<Loan> loanList = findPrestamos.FindAllLoan(id);
            return ResponseEntity.ok().body(loanList);
    }
    @GetMapping("/loan")
    public ResponseEntity<List<Loan>>getAllLoanByUser(){

        List<Loan> loanList = findPrestamos.FindAllLoanByUser();
        return ResponseEntity.ok().body(loanList);
    }

    @GetMapping("/loan/payment")
    public ResponseEntity<List<Loan>>getLoanPayment(){

       List<Loan>response = findPrestamos.findLoanByDate();


        return new ResponseEntity<>(response,HttpStatus.OK);




    }


    @GetMapping("/loan/balance/{id}")
    public ResponseEntity<List<Balance>>getLoan(@PathVariable Long id){
        List<Balance> loanList = findPrestamos.FindLoanBalance(id);
        return ResponseEntity.ok().body(loanList);
    }

    @PostMapping("/loan")
    public ResponseEntity<HttpStatus>CreateLoan(@RequestBody LoanDto loanRequest)  {
        Client client = findClient.findClientById(loanRequest.getClientId());
        loanRequest.setClient(client);
        Loan loan  = loanRequest.getLoanFromDto();


        prestamoCreator.create(loan);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/loan/{id}")
    public ResponseEntity<HttpStatus>updateLoan(@RequestBody LoanDto loanRequest, @PathVariable Long id) {
        Client client = findClient.findClientById(loanRequest.getClientId());
        loanRequest.setClient(client);
        Loan loan  = loanRequest.getLoanFromDto();
        loan.setId(id);

        loanUpdate.update(loan);

        return new ResponseEntity<>(HttpStatus.OK);
    }





    @DeleteMapping("/loan/{id}")
    public  ResponseEntity<HttpStatus>deleteLoan(@PathVariable Long id){

        findPrestamos.findAndDeleteById(id);

        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
