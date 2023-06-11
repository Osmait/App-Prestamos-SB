package com.Prestamos.PrestamosSB.domain.Loan;


import com.Prestamos.PrestamosSB.domain.Loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoanRepository extends JpaRepository<Loan, UUID> {

//    Optional<List<Loan>>findAllByPaymentDateBetween(LocalDateTime payment_date, LocalDateTime payment_date2);

    Optional<List<Loan>> findAllByClientId(UUID ClientId);

//    Optional<List<Loan>> findAllByUserId(UUID UserId);


    @Query(value = "SELECT loan.id, loan.amount - SUM(t.amount) as balance, loan.create_at "
            + "FROM loan JOIN transaction t ON loan.id = t.loan_id where loan.id = :id "
            + "GROUP BY loan.id", nativeQuery = true)
   List<Object[]>findLoanBalance(@Param("id") UUID id);










}
