package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Balance;
import com.Prestamos.PrestamosSB.domain.Loan;

import com.Prestamos.PrestamosSB.domain.LoanRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FindLoan {

    private final LoanRepository loanRepository;
    private final AuthService authService;

    public List<Loan>findLoanByDate( Long id){
        Long currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UsernameNotFoundException("User Not Auth");
        }

        List<Loan> prestamoList;

        prestamoList =  loanRepository.findAllByClientIdAndUserId(id,currentUserId)
                .orElse(new ArrayList<>());

        if (prestamoList.size() <= 0){

            return new ArrayList<>();
        }

        return prestamoList.stream().filter( loan -> loan.getPaymentDate().getDayOfMonth() == LocalDateTime.now().getDayOfMonth()).toList();


    }

    public List<Loan> FindAllLoan(Long id){
        Long currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UsernameNotFoundException("User Not Auth");
        }

        List<Loan> prestamoList;
        prestamoList =  loanRepository.findAllByClientId(id).orElseThrow();
        return  prestamoList;
    }
    public List<Balance> FindLoanBalance(Long id) {
        System.out.println(id);
        List<Object[]> balances = loanRepository.findLoanBalance(id);
        System.out.println(balances);
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
    public void findAndDeleteById(Long id){
        loanRepository.deleteById(id);
    }



}
