package com.Prestamos.PrestamosSB.application.find;


import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindTransaction {


    private final TransactionRepository transactionRepository;

    public List<Transaction> findAllTransaction(Long id){
        return transactionRepository.findAllByLoanId(id).orElse(new ArrayList<>());
    }

    public void findAndDeleteById(Long id){
        transactionRepository.deleteById(id);
    }


}
