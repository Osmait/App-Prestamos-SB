package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.domain.Enums.TransactionType;
import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



@SpringBootTest
class TransactionCreatorTest {

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionCreator transactionCreator;

    @Test
    void create() {
        Transaction transaction1 = Transaction.builder()
                .transactionType(TransactionType.pay)
                .amount(1000.00)
                .loanId(1L)
                .build();

        transactionCreator.create(transaction1);

        Mockito.verify(transactionRepository,Mockito.times(1)).save(transaction1);


    }
}