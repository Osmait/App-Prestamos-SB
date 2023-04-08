package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.*;
import com.Prestamos.PrestamosSB.domain.Enums.TransactionType;
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
    @MockBean
    private AuthService authService;
    @Test
    void create() throws Exception {
        User user = User.builder().email("saulburgos6@gmail.com").name("saul").lastName("burgos").password("12345678").build();

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
        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        transactionCreator.create(transaction1);

        Mockito.verify(transactionRepository,Mockito.times(1)).save(transaction1);


    }
}