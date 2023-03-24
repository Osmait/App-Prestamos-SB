package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.Enums.TransactionType;
import com.Prestamos.PrestamosSB.domain.Loan;
import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import jakarta.transaction.Transactional;
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
@Transactional
class FindTransactionTest {

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private FindTransaction findTransaction;


    @Test
    void findAllTransaction() {
        Client client = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("12345678")
                .build();
        Loan prestamo =Loan.builder().amount(100.00).client(client).build();

        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction1 = Transaction.builder()
                .transactionType(TransactionType.pay)
                .amount(1000.00)
                .loan(prestamo)
                .build();

        Transaction transaction2 = Transaction.builder()
                .transactionType(TransactionType.renewal)
                .amount(10000.00)
                .loan(prestamo)
                .build();

        transactionList.add(transaction1);
        transactionList.add(transaction2);

        Mockito.when(transactionRepository.findAllByLoanId(1L)).thenReturn(Optional.of(transactionList));

        List<Transaction> result = findTransaction.findAllTransaction(1L);
        assertEquals(transactionList.size(),result.size());
        assertEquals(transactionList.get(0),result.get(0));
        assertEquals(transactionList.get(1),result.get(1));


    }

    @Test
    void findAndDeleteById() {
//        Client client = Client.builder()
//                .name("saul")
//                .lastName("burgos")
//                .email("saulburgos6@gmail.com")
//                .phoneNumber("12345678")
//                .build();
//        Loan loan =Loan.builder().amount(100.00).client(client).build();
//        Transaction transaction1 = Transaction.builder()
//                .transactionType(TransactionType.pay)
//                .amount(1000.00)
//                .loan(loan)
//                .build();
        transactionRepository.deleteById(1L);

        Mockito.verify(transactionRepository,Mockito.times(1)).deleteById(1L);

    }
}