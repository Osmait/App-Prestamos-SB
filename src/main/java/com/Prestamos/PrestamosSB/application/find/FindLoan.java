package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Balance;
import com.Prestamos.PrestamosSB.domain.Loan;

import com.Prestamos.PrestamosSB.domain.LoanRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindLoan {


    private final LoanRepository loanRepository;

    public List<Loan> FindAllLoan(Long id){
        List<Loan> prestamoList;
        prestamoList =  loanRepository.findAllByClientId(id).orElse(new ArrayList<>());
        return  prestamoList;
    }
    public List<Balance> FindLoanBalance() {
        List<Object[]> balances = loanRepository.findLoanBalance();
        return balances.stream().map(row -> {
            Balance balance = new Balance();
            balance.setId((Long) row[0]);
            balance.setAmount((Double) row[1]);
            balance.setCreateAt((Date) row[2]);
            return balance;
        }).toList();

    }

    public Loan findLoanById(Long id){
      return  loanRepository.findById(id).orElseThrow();
    }

}
