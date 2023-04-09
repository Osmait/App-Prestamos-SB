package com.Prestamos.PrestamosSB.application.find;


import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Transaction;
import com.Prestamos.PrestamosSB.domain.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


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
            throw new UsernameNotFoundException("User Not Auth");
        }
        return transactionRepository.findByUserId(currentUserId).orElseThrow();
    }

    public void findAndDeleteById(Long id) throws Exception {

        try{
            transactionRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception(e);
        }


    }


}
