package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Balance;
import com.Prestamos.PrestamosSB.domain.Loan.Loan;

import com.Prestamos.PrestamosSB.domain.Loan.LoanRepository;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.NotFoundException;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.UnAuthorizedException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FindLoan {

    private final LoanRepository loanRepository;
    private final AuthService authService;

    public List<Loan>findLoanByDate( ){
        UUID currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UnAuthorizedException("User Not Auth");
        }

        List<Loan> prestamoList =  new ArrayList<>();

//        prestamoList =  loanRepository.findAllByUserId(currentUserId)
//                .orElse(new ArrayList<>());

//        if (prestamoList.size() <= 0){
//
//            return new ArrayList<>();
//        }
//
//        return prestamoList.stream().filter(
//                loan -> loan.getPaymentDate()
//                        .getDayOfMonth() == LocalDateTime.now()
//                        .getDayOfMonth() || loan.getPaymentDate()
//                        .plusDays(15L)
//                        .getDayOfMonth() == LocalDateTime.now()
//                        .getDayOfMonth()).toList();

    return prestamoList;
    }

    public List<Loan> FindAllLoan(Long id){
        UUID currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UnAuthorizedException("User Not Auth");
        }

        List<Loan> prestamoList;
        prestamoList =  loanRepository.findAllByClientId(id).orElseThrow(()-> new NotFoundException("Client Not Found"));
        return  prestamoList;
    }

    public List<Loan> FindAllLoanByUser(){
        UUID currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UnAuthorizedException("User Not Auth");
        }

        List<Loan> prestamoList;
//        prestamoList =  loanRepository.findAllByUserId(currentUserId).orElseThrow( ()-> new NotFoundException(" Not Found"));
        prestamoList = new ArrayList<>();
        return  prestamoList;
    }
    public List<Balance> FindLoanBalance(Long id) {

        List<Object[]> balances = loanRepository.findLoanBalance(id);

        return balances.stream().map(row -> {
            Balance balance = new Balance();
            balance.setId((Long) row[0]);
            balance.setAmount((Double) row[1]);
            balance.setCreateAt((Date) row[2]);
            return balance;
        }).toList();

    }

    public Loan findLoanById(UUID id){
      return  loanRepository.findById(id).orElseThrow(()-> new NotFoundException("Loan Not Found"));
    }
    public void findAndDeleteById(UUID id){
        loanRepository.deleteById(id);
    }



}
