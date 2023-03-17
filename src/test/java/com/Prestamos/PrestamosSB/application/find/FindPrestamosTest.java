package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Prestamo;
import com.Prestamos.PrestamosSB.domain.PrestamoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FindPrestamosTest {

    @MockBean
    private PrestamoRepository prestamoRepository;


    @Autowired
    private  FindPrestamos findPrestamos;


    @Test
    void findPrestamos() {
        List<Prestamo> prestamoList= new ArrayList<>();

        Prestamo prestamo1 = Prestamo.builder().monto(10100.00).clientId(2L).build();

        Prestamo prestamo2 =Prestamo.builder().monto(1000.00).clientId(2L).build();

        prestamoList.add(prestamo1);
        prestamoList.add(prestamo2);

        Mockito.when(prestamoRepository.findAll()).thenReturn(prestamoList);

        List<Prestamo> result= findPrestamos.FindAllPrestamos();

        assertEquals(prestamoList.size(),result.size());
        assertEquals(prestamoList.get(0),result.get(0));
        assertEquals(prestamoList.get(1),result.get(1));



    }
}