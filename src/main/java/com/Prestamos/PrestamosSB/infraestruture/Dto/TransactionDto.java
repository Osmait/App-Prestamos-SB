package com.Prestamos.PrestamosSB.infraestruture.Dto;

import com.Prestamos.PrestamosSB.domain.Enums.TransactionType;
import com.Prestamos.PrestamosSB.domain.Loan;
import com.Prestamos.PrestamosSB.domain.Transaction;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransactionDto {
    @NotNull(message = "TransactionType is require")
    private TransactionType transactionType;

    @NotNull(message = "amount is require")
    private Double amount;

    @NotNull(message = "loanId is require")
    private Long loanId;

    Loan loan;


    public Transaction getTransactionFromDto(){
        return Transaction
                .builder()
                .transactionType(transactionType)
                .amount(amount)
                .loan(loan)
                .build();
    }
}
