package com.Prestamos.PrestamosSB.application.create;


import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.UnAuthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCreator {

    private final AuthService authService;
    private  final TransactionRepository transactionRepository;

    public void create(Transaction transaction) {
        User currentUserId =  authService.getIdCurrentLoggedUser();
        if (currentUserId == null){
            throw new UnAuthorizedException("User Not Auth");
        }
        transaction.setUser(currentUserId);

        transactionRepository.save(transaction);


    }
}
