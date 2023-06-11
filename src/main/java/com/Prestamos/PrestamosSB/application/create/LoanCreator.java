package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Loan.Loan;

import com.Prestamos.PrestamosSB.domain.Loan.LoanRepository;
import com.Prestamos.PrestamosSB.domain.User.User;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.UnAuthorizedException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanCreator {
    private final AuthService authService;

    private final LoanRepository loanRepository;

    public void create(Loan loan)  {

        User currentUserId =  authService.getIdCurrentLoggedUser();

        if (currentUserId == null){
            throw new UnAuthorizedException("User Not Auth");
        }


//            loan.setUser(currentUserId);
        loanRepository.save(loan);


    }
}

