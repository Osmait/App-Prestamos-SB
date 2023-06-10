package com.Prestamos.PrestamosSB.application.find;


import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.UnAuthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindTransaction {

    private final AuthService authService;
    private final TransactionRepository transactionRepository;

    public List<Transaction> findAllTransaction(Long id){
        return transactionRepository.findAllByLoanId(id).orElseThrow();
    }

    public List<Transaction> findAllTransactionbyUser(){

        Long currentUserId =  authService.getIdCurrentLoggedUser().getId();
        if (currentUserId == null){
            throw new UnAuthorizedException("User Not Auth");
        }
//        return transactionRepository.findByUserId(currentUserId).orElseThrow();
        return  new ArrayList<>();
    }



    public void findAndDeleteById(Long id)  {

            transactionRepository.deleteById(id);



    }


}
