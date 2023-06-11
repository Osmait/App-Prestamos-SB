package com.Prestamos.PrestamosSB.domain.Transaction;

import com.Prestamos.PrestamosSB.domain.Transaction.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {


    Optional<List<Transaction>> findAllByLoanId(UUID id);


//    Optional<List<Transaction>> findByUserId(Long UserId);
}
