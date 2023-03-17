package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.domain.Prestamo;
import com.Prestamos.PrestamosSB.domain.PrestamoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrestamoCreatorTest {


    @MockBean
    private PrestamoRepository prestamoRepository;

    @Autowired
    private PrestamoCreator prestamoCreator;


    @Test
    void create() {
        Prestamo prestamo =Prestamo.builder().monto(100.00).clientId(1L).build();
        prestamoCreator.create(prestamo);

        Mockito.verify(prestamoRepository,Mockito.times(1)).save(prestamo);

    }
}