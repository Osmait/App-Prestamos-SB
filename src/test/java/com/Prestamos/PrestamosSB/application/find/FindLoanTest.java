package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Balance;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.Loan;

import com.Prestamos.PrestamosSB.domain.LoanRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FindLoanTest {

    @MockBean
    private LoanRepository prestamoRepository;


    @Autowired
    private FindLoan findPrestamos;


    @Test
    void findLoan() {
        List<Loan> prestamoList= new ArrayList<>();
        Client client = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("12345678")
                .build();

        Loan prestamo1 = Loan.builder().amount(10100.00).client(client).build();

        Loan prestamo2 =Loan.builder().amount(1000.00).client(client).build();

        prestamoList.add(prestamo1);
        prestamoList.add(prestamo2);

        Mockito.when(prestamoRepository.findAllByClientId(1L)).thenReturn(Optional.of(prestamoList));

        List<Loan> result= findPrestamos.FindAllLoan(1L);
        System.out.println(prestamo1);
        assertEquals(prestamoList.size(),result.size());
        assertEquals(prestamoList.get(0),result.get(0));
        assertEquals(prestamoList.get(1),result.get(1));



    }

    @Test
    void findLoanBalance() {
        Object[] row1 = new Object[] {1L, 100.0, new Date()};
        Object[] row2 = new Object[] {2L, 200.0, new Date()};
        List<Object[]> rows = Arrays.asList(row1, row2);




        Mockito.when(prestamoRepository.findLoanBalance()).thenReturn(rows);
        List<Balance> result = findPrestamos.FindLoanBalance();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId().longValue());
        assertEquals(100.0, result.get(0).getAmount(), 0.0);

    }

    @Test
    void findLoanById() {

    }
}