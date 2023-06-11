package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.domain.Loan.Loan;
import com.Prestamos.PrestamosSB.domain.Loan.LoanRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;


@SpringBootTest
class LoanUpdateTest {

    @MockBean
    private LoanRepository loanRepository;
    @Autowired
    private LoanUpdate loanUpdate;





    @Test
    void update() {

        Loan loan1 =Loan.builder().id(1L).amount(100.00).build();
        Mockito.when(loanRepository.findById(loan1.getId())).thenReturn(Optional.of(loan1));
        loanUpdate.update(loan1);
        Mockito.verify(loanRepository,Mockito.times(1)).save(loan1);
    }
}