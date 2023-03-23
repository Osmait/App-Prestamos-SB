package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.domain.Loan;

import com.Prestamos.PrestamosSB.domain.LoanRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanCreator {


    private final LoanRepository prestamoRepository;

    public void create(Loan loan){

        try {
            prestamoRepository.save(loan);
        }catch (Exception e){
            System.out.println("Error Insert Prestamo");
        }

    }
}

