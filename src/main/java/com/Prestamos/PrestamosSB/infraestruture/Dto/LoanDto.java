package com.Prestamos.PrestamosSB.infraestruture.Dto;

import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.Loan;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoanDto {

    @NotNull(message = "amount is require")
    @Size(min = 1)
    private Double amount;

    @NotNull(message = "clientId is require")
    private Long clientId;

    private Client client;


    public Loan getLoanFromDto(){
        return Loan.builder().client(client).amount(amount).build();

    }
}
