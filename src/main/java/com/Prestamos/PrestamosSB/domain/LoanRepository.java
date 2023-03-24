package com.Prestamos.PrestamosSB.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {


    Optional<List<Loan>> findAllByClientId(Long ClientId);


    @Query(value = "SELECT loan.id, loan.amount - SUM(t.amount) as balance, loan.create_at "
            + "FROM loan JOIN transaction t ON loan.id = t.loan_id where loan.id = :id "
            + "GROUP BY loan.id", nativeQuery = true)
   List<Object[]>findLoanBalance(@Param("id") Long id);


}
