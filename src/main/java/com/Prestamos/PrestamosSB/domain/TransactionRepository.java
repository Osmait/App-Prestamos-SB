package com.Prestamos.PrestamosSB.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long> {


    Optional<List<Transaction>> findAllByLoanId(Long id);


    Optional<List<Transaction>> findByUserId(Long UserId);
}
