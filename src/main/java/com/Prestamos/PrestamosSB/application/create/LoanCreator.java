package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Loan;

import com.Prestamos.PrestamosSB.domain.LoanRepository;
import com.Prestamos.PrestamosSB.domain.User;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanCreator {
    private final AuthService authService;

    private final LoanRepository prestamoRepository;

    public void create(Loan loan) throws Exception {

        User currentUserId =  authService.getIdCurrentLoggedUser();
        if (currentUserId == null){
            throw new UsernameNotFoundException("User Not Auth");
        }


        try {
            loan.setUser(currentUserId);
            prestamoRepository.save(loan);
        }catch (Exception e){
            throw  new Exception(e);

        }

    }
}

