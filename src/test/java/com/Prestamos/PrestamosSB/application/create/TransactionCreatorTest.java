package com.Prestamos.PrestamosSB.application.create;

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



@SpringBootTest
@Transactional
class TransactionCreatorTest {

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionCreator transactionCreator;


    @Test
    void create() {
        Client client = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("12345678")
                .build();
        Loan prestamo =Loan.builder().amount(100.00).client(client).build();
        Transaction transaction1 = Transaction.builder()
                .transactionType(TransactionType.pay)
                .amount(1000.00)
                .loan(prestamo)
                .build();

        transactionCreator.create(transaction1);

        Mockito.verify(transactionRepository,Mockito.times(1)).save(transaction1);


    }
}