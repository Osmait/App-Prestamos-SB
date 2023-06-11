package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.*;

import com.Prestamos.PrestamosSB.domain.Client.Client;
import com.Prestamos.PrestamosSB.domain.Loan.Loan;
import com.Prestamos.PrestamosSB.domain.Loan.LoanRepository;
import com.Prestamos.PrestamosSB.domain.User.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FindLoanTest {

    @MockBean
    private LoanRepository prestamoRepository;


    @Autowired
    private FindLoan findPrestamos;

    @MockBean
    private AuthService authService;


    @Test
    void findLoan() {
        User user = User.builder().id(1L).email("saulburgos7@gmail.com").name("saul").lastName("burgos").password("12345678").build();

        List<Loan> prestamoList= new ArrayList<>();

        Client client = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("12345678")
                .build();
        Loan loan1 = Loan.builder().amount(10100.00).interest(20.00).amountOfPayments(6).PaymentDate(LocalDateTime.now()).client(client).build();

        Loan loan2 =Loan.builder().amount(1000.00).interest(10.00).client(client).amountOfPayments(4).PaymentDate(LocalDateTime.now()).build();


        prestamoList.add(loan1);
        prestamoList.add(loan2);
        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        Mockito.when(prestamoRepository.findAllByClientId(user.getId())).thenReturn(Optional.of(prestamoList));

        List<Loan> result= findPrestamos.FindAllLoan(1L);

        assertEquals(prestamoList.size(),result.size());
        assertEquals(prestamoList.get(0),result.get(0));
        assertEquals(prestamoList.get(1),result.get(1));



    }

    @Test
    void findLoanBalance() {
        Object[] row1 = new Object[] {1L, 100.0, new Date()};
        Object[] row2 = new Object[] {2L, 200.0, new Date()};
        List<Object[]> rows = Arrays.asList(row1, row2);




        Mockito.when(prestamoRepository.findLoanBalance(1L)).thenReturn(rows);
        List<Balance> result = findPrestamos.FindLoanBalance(1L);

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId().longValue());
        assertEquals(100.0, result.get(0).getAmount(), 0.0);

    }

    @Test
    void findLoanById() {

    }

    @Test
    void findAndDeleteById() {

        prestamoRepository.deleteById(1L);

        Mockito.verify(prestamoRepository,Mockito.times(1)).deleteById(1L);

    }

    @Test
    void findLoanByDate() {
        User user = User.builder().id(1L).email("saulburgos7@gmail.com").name("saul").lastName("burgos").password("12345678").build();

        List<Loan> prestamoList= new ArrayList<>();

        Client client = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("12345678")
                .build();

        Loan loan1 = Loan.builder().amount(10100.00).interest(20.00).amountOfPayments(6).PaymentDate(LocalDateTime.now()).client(client).build();

        Loan loan2 =Loan.builder().amount(1000.00).interest(10.00).client(client).amountOfPayments(4).PaymentDate(LocalDateTime.now()).build();


        prestamoList.add(loan1);
        prestamoList.add(loan2);
        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        Mockito.when(prestamoRepository.findAllByUserId(user.getId())).thenReturn(Optional.of(prestamoList));

        List<Loan> result= findPrestamos.findLoanByDate();

        assertEquals(prestamoList.size(),result.size());
        assertEquals(prestamoList.get(0),result.get(0));
        assertEquals(prestamoList.get(1),result.get(1));


    }

    @Test
    void findAllLoanByUser() {

        User user = User.builder().id(1L).email("saulburgos7@gmail.com").name("saul").lastName("burgos").password("12345678").build();

        List<Loan> prestamoList= new ArrayList<>();

        Client client = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("12345678")
                .build();

        Loan loan1 = Loan.builder().amount(10100.00).interest(20.00).amountOfPayments(6).PaymentDate(LocalDateTime.now()).client(client).build();

        Loan loan2 =Loan.builder().amount(1000.00).interest(10.00).client(client).amountOfPayments(4).PaymentDate(LocalDateTime.now()).build();


        prestamoList.add(loan1);
        prestamoList.add(loan2);
        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        Mockito.when(prestamoRepository.findAllByUserId(user.getId())).thenReturn(Optional.of(prestamoList));

        List<Loan> result= findPrestamos.FindAllLoanByUser();

        assertEquals(prestamoList.size(),result.size());
        assertEquals(prestamoList.get(0),result.get(0));
        assertEquals(prestamoList.get(1),result.get(1));

    }


}