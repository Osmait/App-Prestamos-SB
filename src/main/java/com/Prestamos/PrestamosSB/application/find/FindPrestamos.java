package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Loan;

import com.Prestamos.PrestamosSB.domain.PrestamoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPrestamos {


    private final   PrestamoRepository prestamoRepository;

    public List<Loan> FindAllPrestamos(Long id){
        List<Loan> prestamoList;
        prestamoList =  prestamoRepository.findAllByClientId(id).orElse(new ArrayList<>());
        return  prestamoList;
    }
//    public List<Loan> FindLoan(){
//        List<Loan> prestamoList;
//        prestamoList =  prestamoRepository.findLoan().orElse(new ArrayList<>());
//        return  prestamoList;
//    }

    public Loan findLoanById(Long id){
      return  prestamoRepository.findById(id).orElseThrow();
    }

}
