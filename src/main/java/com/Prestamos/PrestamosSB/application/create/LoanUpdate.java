package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.domain.Loan;
import com.Prestamos.PrestamosSB.domain.LoanRepository;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.NotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanUpdate {


    private final LoanRepository loanRepository;


    public void update(Loan loan){


        Loan loanDB = loanRepository.findById(loan.getId()).orElseThrow(() -> new NotFoundException("Loan No Found"));

        loanDB.setAmount(loan.getAmount());
        loanDB.setClient(loan.getClient());
        loanDB.setInterest(loan.getInterest());
        loanDB.setAmountOfPayments(loan.getAmountOfPayments());

        loanRepository.save(loanDB);


    }


}
