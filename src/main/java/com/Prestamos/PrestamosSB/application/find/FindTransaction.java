package com.Prestamos.PrestamosSB.application.find;


import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Transaction.Transaction;
import com.Prestamos.PrestamosSB.domain.Transaction.TransactionRepository;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.UnAuthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindTransaction {

    private final AuthService authService;
    private final TransactionRepository transactionRepository;

    public List<Transaction> findAllTransaction(UUID id){
        return transactionRepository.findAllByLoanId(id).orElseThrow();
    }

    public List<Transaction> findAllTransactionbyUser(){

        UUID currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UnAuthorizedException("User Not Auth");
        }
//        return transactionRepository.findByUserId(currentUserId).orElseThrow();
        return  new ArrayList<>();
    }



    public void findAndDeleteById(UUID id)  {

            transactionRepository.deleteById(id);



    }


}
