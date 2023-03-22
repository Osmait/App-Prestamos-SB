package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.PrestamoCreator;
import com.Prestamos.PrestamosSB.application.find.FindClient;
import com.Prestamos.PrestamosSB.application.find.FindPrestamos;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.Loan;
import com.Prestamos.PrestamosSB.infraestruture.Dto.LoanDto;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private  final PrestamoCreator prestamoCreator;
    private  final FindClient findClient;

    private final FindPrestamos findPrestamos;

    @GetMapping("/loan/{id}")
    public ResponseEntity<List<Loan>>getAllLoanByClientId(@PathVariable Long id){
        List<Loan> loanList = findPrestamos.FindAllPrestamos(id);
            return ResponseEntity.ok().body(loanList);
    }

//    @GetMapping("/loan")
//    public ResponseEntity<List<Loan>>getLoan(){
//        List<Loan> loanList = findPrestamos.FindLoan();
//        return ResponseEntity.ok().body(loanList);
//    }

    @PostMapping("/loan")
    public ResponseEntity<HttpStatus>CreateLoan(@RequestBody LoanDto loanRequest){
        Client client = findClient.findCLientById(loanRequest.getClientId());
        loanRequest.setClient(client);
       Loan loan  = loanRequest.getLoanFromDto();
        prestamoCreator.create(loan);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
