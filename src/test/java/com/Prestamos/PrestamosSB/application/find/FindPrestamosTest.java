package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.Loan;

import com.Prestamos.PrestamosSB.domain.PrestamoRepository;
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
class FindPrestamosTest {

    @MockBean
    private PrestamoRepository prestamoRepository;


    @Autowired
    private  FindPrestamos findPrestamos;


    @Test
    void findPrestamos() {
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

        List<Loan> result= findPrestamos.FindAllPrestamos(1L);
        System.out.println(prestamo1);
        assertEquals(prestamoList.size(),result.size());
        assertEquals(prestamoList.get(0),result.get(0));
        assertEquals(prestamoList.get(1),result.get(1));



    }
}