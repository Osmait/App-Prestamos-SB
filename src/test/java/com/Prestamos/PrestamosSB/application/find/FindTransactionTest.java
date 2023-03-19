package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Enums.TransactionType;
import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FindTransactionTest {

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private FindTransaction findTransaction;


    @Test
    void findAllTransaction() {

        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction1 = Transaction.builder()
                .transactionType(TransactionType.pay)
                .amount(1000.00)
                .loanId(1L)
                .build();

        Transaction transaction2 = Transaction.builder()
                .transactionType(TransactionType.renewal)
                .amount(10000.00)
                .loanId(1L)
                .build();

        transactionList.add(transaction1);
        transactionList.add(transaction2);

        Mockito.when(transactionRepository.findAllByLoanId(1L)).thenReturn(Optional.of(transactionList));

        List<Transaction> result = findTransaction.findAllTransaction(1L);
        assertEquals(transactionList.size(),result.size());
        assertEquals(transactionList.get(0),result.get(0));
        assertEquals(transactionList.get(1),result.get(1));


    }
}