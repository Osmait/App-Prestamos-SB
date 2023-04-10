package com.Prestamos.PrestamosSB.application.create;


import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import com.Prestamos.PrestamosSB.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCreator {

    private final AuthService authService;
    private  final TransactionRepository transactionRepository;

    public void create(Transaction transaction) throws Exception {
        User currentUserId =  authService.getIdCurrentLoggedUser();
        if (currentUserId == null){
            throw new UsernameNotFoundException("User Not Auth");
        }
        transaction.setUser(currentUserId);
        try{
            transactionRepository.save(transaction);
        }catch (Exception e){
            throw  new Exception(e);
        }

    }
}
