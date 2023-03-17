package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.domain.Prestamo;
import com.Prestamos.PrestamosSB.domain.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestamoCreator {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public void create(Prestamo prestamo){

        try {
            prestamoRepository.save(prestamo);
        }catch (Exception e){
            System.out.println("Error Insert Prestamo");
        }

    }
}

