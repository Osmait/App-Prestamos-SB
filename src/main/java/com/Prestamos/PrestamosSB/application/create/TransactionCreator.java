package com.Prestamos.PrestamosSB.application.create;


import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCreator {


    private  final TransactionRepository transactionRepository;


    public void create(Transaction transaction){
        transactionRepository.save(transaction);
    }
}
