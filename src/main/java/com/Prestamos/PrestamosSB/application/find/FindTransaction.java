package com.Prestamos.PrestamosSB.application.find;


import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindTransaction {

    private final AuthService authService;
    private final TransactionRepository transactionRepository;

    public List<Transaction> findAllTransaction(Long id){
        return transactionRepository.findAllByLoanId(id).orElse(new ArrayList<>());
    }

    public List<Transaction> findAllTransactionbyUser(){

        Long currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UsernameNotFoundException("User Not Auth");
        }
        return transactionRepository.findByUserId(currentUserId).orElse(new ArrayList<>());
    }

    public void findAndDeleteById(Long id){
        transactionRepository.deleteById(id);
    }


}
