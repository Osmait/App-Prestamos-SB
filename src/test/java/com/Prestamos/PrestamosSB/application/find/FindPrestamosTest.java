package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Loan;

import com.Prestamos.PrestamosSB.domain.PrestamoRepository;
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
class FindPrestamosTest {

    @MockBean
    private PrestamoRepository prestamoRepository;


    @Autowired
    private  FindPrestamos findPrestamos;


    @Test
    void findPrestamos() {
        List<Loan> prestamoList= new ArrayList<>();

        Loan prestamo1 = Loan.builder().amount(10100.00).clientId(2L).build();

        Loan prestamo2 =Loan.builder().amount(1000.00).clientId(2L).build();

        prestamoList.add(prestamo1);
        prestamoList.add(prestamo2);

        Mockito.when(prestamoRepository.findAllByClientId(2L)).thenReturn(Optional.of(prestamoList));

        List<Loan> result= findPrestamos.FindAllPrestamos(2L);
        System.out.println(prestamo1);
        assertEquals(prestamoList.size(),result.size());
        assertEquals(prestamoList.get(0),result.get(0));
        assertEquals(prestamoList.get(1),result.get(1));



    }
}