package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.application.find.FindClient;
import com.Prestamos.PrestamosSB.domain.Client.Client;
import com.Prestamos.PrestamosSB.domain.Client.ClientRepository;
import com.Prestamos.PrestamosSB.domain.Loan.Loan;

import com.Prestamos.PrestamosSB.domain.Loan.LoanRepository;
import com.Prestamos.PrestamosSB.domain.User.User;
import com.Prestamos.PrestamosSB.infraestruture.Dto.LoanDto;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.NotFoundException;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.UnAuthorizedException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoanCreator {


    private final LoanRepository loanRepository;


    public void create(LoanDto loan)  {

        Loan loanDb = loan.getLoanFromDto();


        loanRepository.save(loanDb);


    }
}

