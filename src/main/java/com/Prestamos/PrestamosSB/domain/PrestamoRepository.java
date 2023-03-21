package com.Prestamos.PrestamosSB.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrestamoRepository extends JpaRepository<Loan,Long> {


    Optional<List<Loan>> findAllByClientId(Long ClientId);

    @Query(value = "SELECT loan.id, loan.amount + SUM(transaction.amount) as amount FROM loan JOIN Transaction  ON loan.id = transaction.loan_id",nativeQuery = true)
    Optional<List<Loan>>findLoan();


}
